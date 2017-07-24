package io.larkin.phdplatformer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.larkin.phdplatformer.domain.UserAchievement;
import io.larkin.phdplatformer.domain.User;

public interface UserAchievementRepository extends CrudRepository<UserAchievement, String>{

	List<UserAchievement> findByUser(User user);
	
}
