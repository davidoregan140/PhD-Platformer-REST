package io.larkin.phdplatformer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Level> levels;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<UserAchievement> userAchievemments;

	public Game(String title) {
		this.title = title;
	}
	
	public Game() {}

	public String getTitle() {
		return title;
	}

	public void setGame(String title) {
		this.title = title;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public List<UserAchievement> getUserAchievemments() {
		return userAchievemments;
	}

	public void setUserAchievemments(List<UserAchievement> userAchievemments) {
		this.userAchievemments = userAchievemments;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
}
