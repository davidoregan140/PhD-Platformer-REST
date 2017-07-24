package io.larkin.phdplatformer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Achievement {
	
	@OneToMany(mappedBy = "achievement", cascade = CascadeType.ALL)
	private List<UserAchievement> userAchievements;

	@Id
	private String id;
	
	private String title;
	
	private String description;
	
	private int target;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}
}
