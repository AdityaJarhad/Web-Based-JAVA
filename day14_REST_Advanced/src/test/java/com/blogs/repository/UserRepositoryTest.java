package com.blogs.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blogs.entities.User;

@DataJpaTest //annotation to tell spring boot test frmwork to enable 
	//Data JPA layer(i.e. Service/Controller /modelmapper ...beans will not activated)
@AutoConfigureTestDatabase(replace = Replace.NONE)
//tells spring boot framwork Don't replace original DataSource(i.e mysql)
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	
	@Test	//JUnit annotation to indicate a test method
	void testFindByEmailAndPassword() {
		Optional<User> optional = userRepository.findByEmailAndPassword("a2@gmail.com" , "2234");
		//assert method args -expected, actual
		//
		assertEquals(1l, optional.get().getId());
	}

}
