package io.larkin.phdplatformer.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.larkin.phdplatformer.domain.Achievement;
import io.larkin.phdplatformer.domain.User;
import io.larkin.phdplatformer.domain.UserAchievement;
import io.larkin.phdplatformer.repository.AchievementRepository;
import io.larkin.phdplatformer.repository.UserAchievementRepository;
import io.larkin.phdplatformer.repository.UserRepository;
import io.larkin.phdplatformer.response.BooleanResponseWithMessage;

@Controller
@RequestMapping("/api/user")
public class UserController {

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
	
	@RequestMapping(value = "/register/{username}/{password}/{league}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public @ResponseBody BooleanResponseWithMessage register(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("league") String league) {
		
		// TODO: add some rules to check first, e.g. username length, password complexity
		
		if (!userRepository.exists(username)) {
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			if (!league.equals("--null--")) {
				u.setLeague(league);
			}
			else {
				u.setLeague("");
			}
			userRepository.create(u);
			
			// Easier to just add all the achievements to the user
			Iterable<Achievement> achievements = achievementRepository.findAll();
			for (Achievement a : achievements) {
				UserAchievement ua = new UserAchievement();
				ua.setUser(u);
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
