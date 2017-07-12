package io.larkin.phdplatformer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.larkin.phdplatformer.domain.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int index) throws SQLException {
		User u = new User();
		
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setLeague(rs.getString("league"));
		
		return u;
	}

}
