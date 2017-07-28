package io.larkin.phdplatformer.repository;

import org.springframework.data.repository.CrudRepository;

import io.larkin.phdplatformer.domain.UserLevelComplete;
import io.larkin.phdplatformer.domain.key.UserGameLevelKey;

public interface UserLevelCompleteRepository extends CrudRepository<UserLevelComplete, UserGameLevelKey>{

}
