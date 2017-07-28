package io.larkin.phdplatformer.domain;

public class Pickup {
	
	private String id;
	
	private String game;
	
	private String inGameEffect;
	
	private String realWorldEffect;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInGameEffect() {
		return inGameEffect;
	}

	public void setInGameEffect(String inGameEffect) {
		this.inGameEffect = inGameEffect;
	}

	public String getRealWorldEffect() {
		return realWorldEffect;
	}

	public void setRealWorldEffect(String realWorldEffect) {
		this.realWorldEffect = realWorldEffect;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

}
