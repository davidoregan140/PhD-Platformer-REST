package io.larkin.phdplatformer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.larkin.phdplatformer.domain.UserAchievement;
import io.larkin.phdplatformer.domain.Game;
import io.larkin.phdplatformer.domain.User;

public interface UserAchievementRepository extends CrudRepository<UserAchievement, Integer>{

	List<UserAchievement> findByUser(User user);
	
	List<UserAchievement> findByUserAndGame(User user, Game game);
	
}
