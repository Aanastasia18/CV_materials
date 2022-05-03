
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import exceptions.*;
import domain.User;

public class UserEntityTest {
	
	private User u;
	private Faker faker = new Faker();
	
	
	
	@BeforeEach
	public void initeDefaultUser() {
		u = new User(); 
	}
	
	
	@Test
	@DisplayName("The test which checks \"correct\" user names as \"Nick\" and etc.")
	public void setCorrectUserNameTest() throws UserExceptions {
		for(int i = 0; i < 100; i++ ) {
			u.setUserName(faker.name().username());
			while(u.getUserName().length() < 3 || u.getUserName().length() > 16) {
				u.setUserName(faker.name().username());
			}
			assertNotNull(u.getUserName());
		}
	}
	
	
	@Test
	@DisplayName("The test which checks \"correct\" user e-mails as \"nick_344@gmail.com\" and etc.")
	public void setCorrectEmailTest() throws UserExceptions {
		for(int i = 0; i < 100; i++ ) {
			u.setEmail(faker.internet().emailAddress());
			assertNotNull(u.getEmail());
		}
	}
	
	@Test
	@DisplayName("The test which checks \"correct\" user passwords as \"NKbfbf323!\" and etc.")
	public void setCorrectPasswordTest() throws UserExceptions {
		u.setPassword("ggfhD4!");
		assertNotNull(u.getPassword());
		u.setPassword("gvngn35345LKMLK!");
		assertNotNull(u.getPassword());
		u.setPassword("lkmlkGm25445!");
		assertNotNull(u.getPassword());
	}
	
	@Test
	@DisplayName("The test which checks \"correct\" user's date of birthday as \"2010.11.15\" and etc.")
	public void setCorrectDobTest() throws UserExceptions {
		for(int i = 0; i < 10; i++) {
			u.setDob(faker.date().between(new Date(1900, Calendar.DECEMBER,31), new Date(2011, Calendar.DECEMBER,31)));
			assertNotNull(u.getDob());
		}
	}
	
	@Test
	@DisplayName("The test which checks \"correct\" users' reality as \"true\".")
	public void setInvalidRealFieldTest() throws UserExceptions {
		u.setReal(true);
		assertTrue(u.getReal());
	}

}
