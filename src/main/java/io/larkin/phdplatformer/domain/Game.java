package io.larkin.phdplatformer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Game {
	
	@Id
	private String game;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Level> levels;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<UserAchievement> userAchievemments;

	public Game(String game) {
		this.game = game;
	}
	
	public Game() {}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
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
	
	
}
