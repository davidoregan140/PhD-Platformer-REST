package io.larkin.phdplatformer.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.larkin.phdplatformer.domain.User;
import io.larkin.phdplatformer.mapper.UserRowMapper;

/**
 * TODO: Implement a hashing + salt algorithm
 * 
 * @author Larkin.Cunningham
 *
 */
@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate template;
	
	/**
	 * Get the user object, but without the password
	 * 
	 * @param username
	 * @return User object
	 */
	public User get(String username) {
		String sql = "SELECT username, league FROM user WHERE username = ?";
		Map<String, Object> m = template.queryForMap(sql, new Object[] {username});
		User u = new User();
		u.setUsername(m.get("username").toString());
		u.setLeague(m.get("league").toString());
		return u;
	}
	
	public boolean authenticate(String username, String password) {
		String sql = "SELECT COUNT(*) FROM user WHERE username = ? AND password = ?";
		int count = template.queryForObject(sql, new Object[] {username, password}, Integer.class);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
	public boolean exists(String username) {
		String sql = "SELECT COUNT(*) FROM user WHERE username = ?";
		int count = template.queryForObject(sql, new Object[] {username}, Integer.class);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
	public User getByUsername(String username) {
		String sql = "SELECT * FROM user WHERE username = ?";
		try {
			User user = template.queryForObject(sql, new Object[] {username}, new UserRowMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public User getByEmail(String email) {
		String sql = "SELECT * FROM user WHERE email = ?";
		try {
			User user = template.queryForObject(sql, new Object[] {email}, new UserRowMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public void create(User u) {
		String sql = "INSERT INTO user (username, password, league, email) VALUES (?, ?, ?, ?)";
		template.update(sql, new Object[] {u.getUsername(), u.getPassword(), u.getLeague(), u.getEmail()});
	}

	public boolean existsEmail(String email) {
		String sql = "SELECT COUNT(*) FROM user WHERE email = ?";
		int count = template.queryForObject(sql, new Object[] {email}, Integer.class);
		if (count > 0) {
			return true;
		}
		return false;
	}
}
