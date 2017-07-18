package io.larkin.phdplatformer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.larkin.phdplatformer.domain.Level;

public interface LevelRepository extends CrudRepository<Level, String>{

}
