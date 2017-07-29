package io.larkin.phdplatformer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.larkin.phdplatformer.domain.UserAchievement;
import io.larkin.phdplatformer.domain.Game;
import io.larkin.phdplatformer.domain.User;

public interface UserAchievementRepository extends CrudRepository<UserAchievement, Integer>{

	//@Query("from UserAchievement ua where ua.user.username = ?1 and ua.game.title = ?2")
	List<UserAchievement> findByUserUsernameAndGameTitle(String username, String game);
	
}
