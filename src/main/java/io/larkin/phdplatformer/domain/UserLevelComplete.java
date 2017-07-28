package io.larkin.phdplatformer.domain;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import io.larkin.phdplatformer.domain.key.UserGameLevelKey;

@Entity
public class UserLevelComplete {
	
	@EmbeddedId
	private UserGameLevelKey key;
	
	private int highScore;
	
	private Date highScoreDate;
	
	private int secondsToComplete;
	
	private Date fastestTimeDate;

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

	public Date getHighScoreDate() {
		return highScoreDate;
	}

	public void setHighScoreDate(Date highScoreDate) {
		this.highScoreDate = highScoreDate;
	}

	public Date getFastestTimeDate() {
		return fastestTimeDate;
	}

	public void setFastestTimeDate(Date fastestTimeDate) {
		this.fastestTimeDate = fastestTimeDate;
	}

}
