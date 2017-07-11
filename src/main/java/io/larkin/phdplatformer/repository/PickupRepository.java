package io.larkin.phdplatformer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.larkin.phdplatformer.domain.Pickup;
import io.larkin.phdplatformer.mapper.PickupRowMapper;

@Repository
public class PickupRepository {

	@Autowired
	JdbcTemplate template;
	
	public Pickup get(String id) {
		String sql = "SELECT id, inGameEffect, realWorldEffect FROM pickups WHERE id = ?";
		return template.queryForObject(sql, new Object[] {id}, new PickupRowMapper());
	}
}
