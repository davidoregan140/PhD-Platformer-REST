package io.larkin.phdplatformer.domain.key;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class UserGameLevelKey implements Serializable {
	public String username;
	
	public String game;
	
	public String level;

	public UserGameLevelKey(String username, String game, String level) {
		super();
		this.username = username;
		this.game = game;
		this.level = level;
	}
	
}
