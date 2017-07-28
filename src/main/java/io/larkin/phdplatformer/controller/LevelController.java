package io.larkin.phdplatformer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.larkin.phdplatformer.domain.UserLevelComplete;
import io.larkin.phdplatformer.repository.UserLevelCompleteRepository;

@Controller
@RequestMapping("/api/level")
public class LevelController {

	@Autowired
	UserLevelCompleteRepository ulcRepository;
	
	@RequestMapping(value = "/complete", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	//@Transactional
	public void complete(@RequestBody UserLevelComplete request) {
		UserLevelComplete ulc = ulcRepository.findOne(request.getKey());
		boolean saveIt = false;
		if (ulc != null) {
			
			if (ulc.getHighScore() <= request.getHighScore()) {
				ulc.setHighScore(request.getHighScore());
				saveIt = true;
			}
			if (ulc.getSecondsToComplete() >= request.getSecondsToComplete()) {
				ulc.setSecondsToComplete(request.getSecondsToComplete());
				saveIt = true;
			}
		} else {
			ulc = request;
			saveIt = true;
		}
		if (saveIt) {
			ulcRepository.save(ulc);
		}
	}
	
}
