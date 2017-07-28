package io.larkin.phdplatformer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.larkin.phdplatformer.domain.Pickup;

public class PickupRowMapper implements RowMapper<Pickup> {

	@Override
	public Pickup mapRow(ResultSet rs, int index) throws SQLException {
		Pickup p = new Pickup();
		
		p.setId(rs.getString("id"));
		p.setInGameEffect(rs.getString("inGameEffect"));
		p.setRealWorldEffect(rs.getString("realWorldEffect"));
		p.setGame(rs.getString("game"));
		
		return p;
	}

}
