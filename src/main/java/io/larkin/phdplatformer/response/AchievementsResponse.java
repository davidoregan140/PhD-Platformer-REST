package io.larkin.phdplatformer.response;

import io.larkin.phdplatformer.domain.Achievement;

public class AchievementsResponse {

	public Iterable<Achievement> achievements;

	public Iterable<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(Iterable<Achievement> achievements) {
		this.achievements = achievements;
	}

	public AchievementsResponse(Iterable<Achievement> achievements) {
		super();
		this.achievements = achievements;
	}
}
