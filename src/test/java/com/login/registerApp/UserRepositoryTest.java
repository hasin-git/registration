package com.login.registerApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.login.registerApp.entity.User;
import com.login.registerApp.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	 	@Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private UserRepository repo;
	     
	    // test methods go below
	    @Test
	    public void testCreateUser() {
	        User user = new User();
	        user.setEmail("Ashley_33@gmail.com");
	        user.setPassword("ash123");
	        user.setFirstName("Ashley");
	        user.setLastName("Munoz");
	         
	        User savedUser = repo.save(user);
	         
	        User existUser = entityManager.find(User.class, savedUser.getId());
	         
	        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());	         
	    }
	    
	   // @Test
	   // public void testFindUserByEmail() {
	   // 	String email = "David12@gmail.com";
	    	
	   // 	User user = repo.findByEmail(email);
	    	
	   // 	assertThat(user.getEmail()).isEqualTo(email);
	   // }    	    
}
