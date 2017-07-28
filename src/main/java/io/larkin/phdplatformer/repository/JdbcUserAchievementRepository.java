package io.larkin.phdplatformer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.larkin.phdplatformer.domain.UserAchievement;

/**
 * Use JDBC directly to get around issues with cascading in JPA.
 * 
 * @author Larkin.Cunningham
 *
 */
@Repository
public class JdbcUserAchievementRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * Update the user achievement, but only where it is "dirty".
	 * 
	 * @param ua
	 */
	public void update(UserAchievement ua) {
		String sql = "UPDATE user_achievement SET is_achieved = ?, progress = ?, last_update = ? WHERE id = ? AND (is_achieved <> ? OR progress <> ?)";
		jdbcTemplate.update(sql, new Object[] {ua.getIsAchieved(), ua.getProgress(), ua.getLastUpdate(), ua.getId(), ua.getIsAchieved(), ua.getProgress()});
	}
	
	/**
	 * Add a user achievement.
	 * 
	 * @param ua
	 */
	public void add(UserAchievement ua) {
		String sql = "INSERT INTO user_achievement (username, game, achievement_id, is_achieved, progress) VALUES (?, ?, ?, ?, ?)";
		try {
			jdbcTemplate.update(sql, new Object[] {ua.getUser().getUsername(), ua.getGame().getGame(), ua.getAchievement().getId(), ua.getIsAchieved(), ua.getProgress()});
		} catch (Exception e) {
			// likely to be a MySQLIntegrityConstraintViolationException that we can ignore
		}
	}

}
