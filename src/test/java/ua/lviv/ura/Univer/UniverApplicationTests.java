package ua.lviv.ura.Univer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.ura.univer.UniverApplication;
import ua.lviv.ura.univer.dao.UserRepository;
import ua.lviv.ura.univer.domain.User;
import ua.lviv.ura.univer.domain.UserRole;
import ua.lviv.ura.univer.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UniverApplication.class)
public class UniverApplicationTests {
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User("a@a", "a", "a", UserRole.ROLE_USER, "a" );
		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));
		
		User userFromDB = users.get(0);
		
		assertTrue(userFromDB.getEmail().equals(user.getEmail()));
		assertTrue(userFromDB.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDB.getLastName().equals(user.getLastName()));
		assertTrue(userFromDB.getPassword().equals(user.getPassword()));
		assertTrue(userFromDB.getRole().equals(user.getRole()));
	}
	
	@Test
	public void testFindByEmail() {
		User user = new User("a@a", "a", "a", UserRole.ROLE_USER, "a");
		User user2 = new User("b@b", "b", "b", UserRole.ROLE_USER, "a");
		userRepository.saveAll(Arrays.asList(user, user2));
		
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(2));
		
		User userFromDB = userService.findByEmail("b@b");
		
		assertTrue(userFromDB.equals(user2));
		assertTrue(userFromDB.getFirstName().equals(user2.getFirstName()));
		assertTrue(userFromDB.getLastName().equals(user2.getLastName()));
		assertTrue(userFromDB.getEmail().equals(user2.getEmail()));
		assertTrue(userFromDB.getPassword().equals(user2.getPassword()));
		assertTrue(userFromDB.getRole().equals(user2.getRole()));
	}
	
}
