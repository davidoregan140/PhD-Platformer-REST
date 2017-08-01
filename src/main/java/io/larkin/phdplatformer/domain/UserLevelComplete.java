package io.larkin.phdplatformer.domain;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.larkin.phdplatformer.domain.key.UserGameLevelKey;

@Entity
public class UserLevelComplete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name = "level_id")
	@JsonBackReference(value="level-userlevelcomplete")
	private Level level;
	
	@ManyToOne
	@JoinColumn(name = "username")
	@JsonBackReference(value="user-userlevelcomplete")
	private User user;
	
	private int highScore;
	
	private Date highScoreDate;
	
	private int secondsToComplete;
	
	private Date fastestTimeDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
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
