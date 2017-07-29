package io.larkin.phdplatformer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.larkin.phdplatformer.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer>{

	@Query("from Question q where q.level.name = ?1 and q.level.game.title = ?2")
	Iterable<Question> findByGameLevel(String level, String game);
}
