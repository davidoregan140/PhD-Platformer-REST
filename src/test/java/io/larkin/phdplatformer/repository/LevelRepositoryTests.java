package io.larkin.phdplatformer.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import io.larkin.phdplatformer.PhDPlatformerApplication;
import io.larkin.phdplatformer.domain.Level;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(PhDPlatformerApplication.class)
public class LevelRepositoryTests {

	@Autowired
	LevelRepository levelRepository;
	
	@Test
	@Transactional
	public void findOne() {
		Level l = levelRepository.findOne("First");
		assertEquals(2, l.getQuestions().size());
	}
	
}
