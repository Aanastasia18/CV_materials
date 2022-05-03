import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import exceptions.*;
import domain.User;

public class UserEnityFailureTest {

	private User u;
	private Faker faker = new Faker();
	
	@BeforeEach
	public void initeDefaultUser() {
		u = new User(); 
	}
	
	@Test
	@DisplayName("The test which checks \"incorrect\" user names as \"O\" and etc.")
	public void setInvalidNameFieldTest() throws UserExceptions{
			u.setUserName("L");
			assertNull(u.getUserName());
			//assertEquals(new InvalidUserNameException() ,u.setUserName("L"));
			

	}
	
	
	@Test
	@DisplayName("The test which checks \"incorrect\" user emails as \"Oooo.ru\" and etc.")
	public void setInvalidEmailFieldTest()  throws UserExceptions{
		try {
			u.setEmail("this_is_not_an_email_adress");
		} catch(UserExceptions e) {
			assertEquals("Incorrect email addess!!!", e.InvalidUserEmailException());
		}
	}
	
	
	@Test
	@DisplayName("The test which checks \"incorrect\" user passwords as \"ooooooooooo\" and etc.")
	public void setInvalidUserPasswordException() throws UserExceptions {
		u.setPassword("aaaaaa");
		assertNull(u.getPassword());
	}
	
	
	@Test
	@DisplayName("The test which checks \"incorrect\" users' date of birthday as \"1798.12.33\" and etc.")
	public void setInvalidDobFieldTest() throws UserExceptions {
		u.setDob(new Date(1888, Calendar.DECEMBER, 10));
		assertNull(u.getDob());
	}
	
	
	@Test
	@DisplayName("The test which checks \"incorrect\" users' reality as \"false\".")
	public void setInvalidRealFieldTest() throws UserExceptions {
		u.setReal(false);
		assertTrue(!u.getReal());
	}
	
	
}
