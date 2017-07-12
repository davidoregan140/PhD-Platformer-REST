package io.larkin.phdplatformer.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import io.larkin.phdplatformer.PhDPlatformerApplication;
import io.larkin.phdplatformer.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(PhDPlatformerApplication.class)
public class UserRepositoryTests {

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void get() {
		User u = userRepository.get("larkin");
		assertEquals("larkin", u.getUsername());
	}

}
