package io.larkin.phdplatformer.response;

import java.util.List;

import io.larkin.phdplatformer.domain.UserAchievement;

public class UserAchievementsResponse {

	public List<UserAchievement> achievements;

	public List<UserAchievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<UserAchievement> achievements) {
		this.achievements = achievements;
	}

	public UserAchievementsResponse(List<UserAchievement> achievements) {
		super();
		this.achievements = achievements;
	}
}
