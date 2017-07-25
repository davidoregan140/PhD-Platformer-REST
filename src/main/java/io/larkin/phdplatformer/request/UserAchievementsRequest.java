package io.larkin.phdplatformer.request;

import io.larkin.phdplatformer.domain.UserAchievement;

public class UserAchievementsRequest {

	UserAchievement[] userAchievements;

	public UserAchievement[] getUserAchievements() {
		return userAchievements;
	}

	public void setUserAchievements(UserAchievement[] userAchievements) {
		this.userAchievements = userAchievements;
	}

}
