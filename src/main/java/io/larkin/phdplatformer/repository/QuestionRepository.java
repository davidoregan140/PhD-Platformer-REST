package io.larkin.phdplatformer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.larkin.phdplatformer.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer>{
	@Query("select q.id from Question q where q.level.name = ?1")
	List<Integer> getIdByLevelName(String name);
}
