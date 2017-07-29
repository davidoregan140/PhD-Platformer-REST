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
	
	public Pickup get(String id, String game) {
		String sql = "SELECT p.id, p.game_id, p.inGameEffect, p.realWorldEffect FROM pickups p, game g WHERE p.id = ? AND p.game_id = g.id and g.title = ?";
		return template.queryForObject(sql, new Object[] {id, game}, new PickupRowMapper());
	}
}
