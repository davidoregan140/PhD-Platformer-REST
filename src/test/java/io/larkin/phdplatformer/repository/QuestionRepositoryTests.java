package io.larkin.phdplatformer.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import io.larkin.phdplatformer.PhDPlatformerApplication;
import io.larkin.phdplatformer.domain.Level;
import io.larkin.phdplatformer.domain.Question;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(PhDPlatformerApplication.class)
@Profile("development")
public class QuestionRepositoryTests {

	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	@Transactional
	public void findOne() {
		Question q = questionRepository.findOne(2);
		assertEquals(3, q.getAnswers().size());
	}

	@Test
	@Transactional
	public void findByGameLevel() {
		Iterable<Question> qs = questionRepository.findByGameLevel("PhD1", "PhDPlatformer");
		int size = 0;
		for(Question value : qs) {
		   size++;
		}
		assertEquals(1, size);
	}
	
}
