package io.larkin.phdplatformer.controller;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.larkin.phdplatformer.PhDPlatformerApplication;
import io.larkin.phdplatformer.domain.Achievement;
import io.larkin.phdplatformer.domain.User;
import io.larkin.phdplatformer.domain.UserAchievement;
import io.larkin.phdplatformer.repository.AchievementRepository;
import io.larkin.phdplatformer.repository.UserAchievementRepository;
import io.larkin.phdplatformer.repository.UserRepository;
import io.larkin.phdplatformer.request.ForgotRequest;
import io.larkin.phdplatformer.response.BooleanResponseWithMessage;

@Controller
@RequestMapping("/api/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhDPlatformerApplication.class);	

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserAchievementRepository userAchievementRepository;
	
	@Autowired
	AchievementRepository achievementRepository;
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User get(@PathVariable("username") String username) {
		User u = userRepository.get(username);
		return u;
	}
	
	@RequestMapping(value = "/exists/{username}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody BooleanResponseWithMessage exists(@PathVariable("username") String username) {
		return new BooleanResponseWithMessage(userRepository.exists(username));
	}
	
	@RequestMapping(value = "/authenticate/{username}/{password}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User authenticate(@PathVariable("username") String username, @PathVariable("password") String password) {
		if (userRepository.authenticate(username, password)) {
			return userRepository.get(username);
		}
		return new User();
	}
	
	@RequestMapping(value = "/recover", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void recoverByEmail(@RequestBody ForgotRequest request) {
		User user;
		if (request.getType().equals("email")) {
			user = userRepository.getByEmail(request.getData());
		} else {
			user = userRepository.getByUsername(request.getData());
		}
		if (user != null) {
			try{
				sendEmailTo(user);
			}
			catch (MailException e) {
				logger.error("Could not send reminder email to " + request.getData());
				// just ignore email not existing
			} finally {
				// nothing
			}
		}
	}
	
	@Autowired
    public JavaMailSender emailSender;
	
	private void sendEmailTo(User user) {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(user.getEmail()); 
        message.setSubject("Login details reminder"); 
        message.setText("Your username is " + user.getUsername() + " and your password is " + user.getPassword());
        emailSender.send(message);
	}

	@RequestMapping(value = "/register", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public @ResponseBody BooleanResponseWithMessage register(@RequestBody User user) {
		
		if (!userRepository.exists(user.getUsername())) {
			if (user.getLeague().equals("--null--")) {
				user.setLeague("");
			}

			if (userRepository.existsEmail(user.getEmail())) {
				return new BooleanResponseWithMessage(false, "Email already exists. Please try a different email or recover other user.");
			}

			userRepository.create(user);

			// Easier to just add all the achievements to the user
			Iterable<Achievement> achievements = achievementRepository.findAll();
			for (Achievement a : achievements) {
				UserAchievement ua = new UserAchievement();
				ua.setUser(user);
				ua.setAchievement(a);
				ua.setProgress(0);
				ua.setIsAchieved(false);
				userAchievementRepository.save(ua);
			}
			
			return new BooleanResponseWithMessage(true, "User successfully registered. You can now login.");
		} else {
			return new BooleanResponseWithMessage(false, "Username already exists. Please try a different username.");
		}
	}	
}
