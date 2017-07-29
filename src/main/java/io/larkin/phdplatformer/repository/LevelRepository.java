package io.larkin.phdplatformer.repository;

import org.springframework.data.repository.CrudRepository;

import io.larkin.phdplatformer.domain.Level;

public interface LevelRepository extends CrudRepository<Level, String>{
	Level findByNameAndGame(String level, String game);
}
