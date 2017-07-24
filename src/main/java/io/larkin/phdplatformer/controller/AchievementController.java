package io.larkin.phdplatformer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.larkin.phdplatformer.domain.UserAchievement;
import io.larkin.phdplatformer.domain.Achievement;
import io.larkin.phdplatformer.domain.User;
import io.larkin.phdplatformer.repository.AchievementRepository;
import io.larkin.phdplatformer.repository.UserAchievementRepository;
import io.larkin.phdplatformer.response.AchievementsResponse;
import io.larkin.phdplatformer.response.UserAchievementsResponse;

@Controller
@RequestMapping("/api/achievement")
public class AchievementController {

	@Autowired
	UserAchievementRepository userAchievementRepository;
	
	@Autowired
	AchievementRepository achievementRepository;
	
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody UserAchievementsResponse getAchievements(@PathVariable("username") String username) {
		
		User u = new User();
		u.setUsername(username);
		
		List<UserAchievement> achievements = userAchievementRepository.findByUser(u);
		
		return new UserAchievementsResponse(achievements);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody AchievementsResponse getAllAchievements() {
		
		Iterable<Achievement> achievements = achievementRepository.findAll();
		
		return new AchievementsResponse(achievements);
	}
}
