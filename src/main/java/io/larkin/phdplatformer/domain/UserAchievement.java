package io.larkin.phdplatformer.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties(value = { "user" })
public class UserAchievement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "achievement_id")
	private Achievement achievement;
	
	private Boolean isAchieved;
	
	private Integer progress;
	
	private Date dateAchieved;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public Boolean getIsAchieved() {
		return isAchieved;
	}

	public void setIsAchieved(Boolean isAchieved) {
		this.isAchieved = isAchieved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Achievement getAchievement() {
		return achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Date getDateAchieved() {
		return dateAchieved;
	}

	public void setDateAchieved(Date dateAchieved) {
		this.dateAchieved = dateAchieved;
	}
	
}
