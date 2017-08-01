package io.larkin.phdplatformer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "game_id")	
	@JsonBackReference(value="game-level")
	private Game game;
	
	@OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
	@JsonManagedReference(value="level-question")
	public List<Question> questions;

	@OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
	@JsonManagedReference(value="level-userlevelcomplete")
	public List<UserLevelComplete> userLevelCompletions;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}
