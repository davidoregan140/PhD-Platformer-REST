package io.larkin.phdplatformer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.larkin.phdplatformer.domain.UserAchievement;

@Repository
public class JdbcUserAchievementRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void update(UserAchievement ua) {
		String sql = "UPDATE user_achievement SET is_achieved = ?, progress = ? WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] {ua.getIsAchieved(), ua.getProgress(), ua.getId()});
	}
}
