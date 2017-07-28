package io.larkin.phdplatformer.controller;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.larkin.phdplatformer.domain.UserAchievement;
import io.larkin.phdplatformer.domain.Achievement;
import io.larkin.phdplatformer.domain.Game;
import io.larkin.phdplatformer.domain.User;
import io.larkin.phdplatformer.repository.AchievementRepository;
import io.larkin.phdplatformer.repository.JdbcUserAchievementRepository;
import io.larkin.phdplatformer.repository.UserAchievementRepository;
import io.larkin.phdplatformer.request.UserAchievementsRequest;
import io.larkin.phdplatformer.response.AchievementsResponse;
import io.larkin.phdplatformer.response.UserAchievementsResponse;

@Controller
@RequestMapping("/api/achievement")
public class AchievementController {

	@Autowired
	UserAchievementRepository userAchievementRepository;

	@Autowired
	JdbcUserAchievementRepository jdbcUserAchievementRepository;
	
	@Autowired
	AchievementRepository achievementRepository;
	
	@RequestMapping(value = "/user/{username}/game/{game}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody UserAchievementsResponse getAchievements(@PathVariable("username") String username, @PathVariable("game") String game) {
		
		User u = new User();
		u.setUsername(username);
		Game g = new Game(game);
		
		List<UserAchievement> achievements = userAchievementRepository.findByUserAndGame(u, g);
		
		return new UserAchievementsResponse(achievements);
	}
	
	@RequestMapping(value = "/saveall", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	//@Transactional
	public void saveAll(@RequestBody UserAchievementsRequest request) {
		for (int i = 0; i < request.getUserAchievements().length; i++) {
			// update timestamp 
			request.getUserAchievements()[i].setLastUpdate(new Date(new java.util.Date().getTime()));
			if (request.getUserAchievements()[i].getId() == 0) {
				// New achievement to add
				jdbcUserAchievementRepository.add(request.getUserAchievements()[i]);
			}
			jdbcUserAchievementRepository.update(request.getUserAchievements()[i]);
		}
	}
	
}
