package io.larkin.phdplatformer.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import io.larkin.phdplatformer.domain.key.UserGameLevelKey;

@Entity
public class UserLevelComplete {
	
	@EmbeddedId
	private UserGameLevelKey key;
	
	private int highScore;
	
	private int secondsToComplete;

	public UserGameLevelKey getKey() {
		return key;
	}

	public void setKey(UserGameLevelKey key) {
		this.key = key;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public int getSecondsToComplete() {
		return secondsToComplete;
	}

	public void setSecondsToComplete(int secondsToComplete) {
		this.secondsToComplete = secondsToComplete;
	}
	
	
}
