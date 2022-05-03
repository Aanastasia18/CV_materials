package domain;

import exceptions.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Template for objects of type "USER"
 * encapsulation
 * 
 * @author 37360
 *
 */
public class User {
	private String userName;
	private String email;
	private String password;
	private Date dob;
	private Boolean real;
	private UUID uuid;
	private String avatarURL;
	private Date lastOnline;
	
	
	/**
	 * This is the constructor for the User class with such parameters
	 * @param userName
	 * @param email
	 * @param password
	 * @throws InvalidEmailException 
	 */
	
	public User() {}
	
	public User(String userName, String email, String password, Date dob, Boolean real, String avatarURL) throws UserExceptions{
		super();
		setUserName(userName);
		setEmail(email);
		setPassword(password);
		setDob(dob);
		setReal(real);
		setUuid(uuid);
		// initialize the list of future relationships
		setAvatarURL(avatarURL);
	}
	

////////////////////////////////////////////////////////////////////////
	
	/**
	 * getter for UserName
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * setter for UserName with the length from 2 to 16
	 * @param userName
	 */
	public void setUserName(String userName) throws UserExceptions {
		if(userName.length() < 2) {
			//System.out.println("The user name is too short!");
		} else {
			if(userName.length() > 16) {
				//System.out.println("The user name is too long!");
			} else {
				this.userName = userName;
			}
		}
		
	}
	
	/**
	 * getter for UserEmail
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * setter for UserEmail which cannot be empty
	 * @param email
	 */
	public void setEmail(String email) throws UserExceptions{
		if(email.contains("@") && email.contains(".") && email.lastIndexOf("@") < email.lastIndexOf(".") ) {
			this.email = email;
		} else {
			throw new UserExceptions();
		}
	}
	
	/**
	 * getter for UserPassword
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * setter for UserPassword with the conditions
	 * the length from 6 to 32
	 * must contain at least:
	 * 1 Upper case
	 * 1 Lower case
	 * 1 digit
	 * 1 symbol like !@#$%^&+=
	 * @param password
	 */
	public void setPassword(String password) throws UserExceptions{
		Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])");
		Matcher matcher = pattern.matcher(password);
		
		if(matcher.find() == true  && password.length() <=32 && password.length() >=6) {
			this.password = password;
		} else {
			System.out.println("Password has to contain at least 6 characters, not longer than 32, has to contain at least 1 Upper case, 1 Lower case, one digit and one sign (like !,#... etc)");
		}
	}

	

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) throws UserExceptions{
		if(dob.before(new Date(2011, Calendar.DECEMBER,31)) && dob.after(new Date(1900, Calendar.DECEMBER,31))) {
		this.dob = dob;
		}
	}

	public Boolean getReal() {
		return real;
	}

	public void setReal(Boolean real) {
		this.real = real;
	}

	public UUID getUuid() {
		return uuid;
	}
	
	
	public void setUuid(UUID uuid) {
		this.uuid = UUID.randomUUID();
	}
	
	

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	public Date getLastOnline() {
		return lastOnline;
	}

	public void setLastOnline(Date lastOnline) {
		this.lastOnline = lastOnline;
	}
	
	public String onlineTimeAgo(Date lastOnlain) {
		
		Date dateNow = new Date();
		
		long diff = dateNow.getTime() - lastOnlain.getTime();
		
		
		if(timeDifference(lastOnlain, "minutes") < 5) {
			return "online now";
		} else {
			if(timeDifference(lastOnlain, "minutes") < 55) {
				return "last seen " + timeDifference(lastOnlain, "minutes") + " minutes ago";
			} else {
				if(timeDifference(lastOnlain, "hours") <= 23) {
					return "last seen " + timeDifference(lastOnlain, "hours") + " hours ago";
				} else {
					if(timeDifference(lastOnlain, "days") <= 6) {
						return "last seen " + timeDifference(lastOnlain, "days") + " days ago";
					} else {
						if(timeDifference(lastOnlain, "days") <= 30) {
							return "last seen " + timeDifference(lastOnlain, "days")/7 + " weeks ago";
						} else {
							return "last seen long time ago";
						}
					}
				}
			}
		}
		
	}
	
	public long timeDifference(Date givenTime, String dopInfo) {
	
		long diff = (new Date()).getTime() - givenTime.getTime();
		TimeUnit tu = TimeUnit.MILLISECONDS;
		
		switch(dopInfo) {
		
		case "minutes" : return tu.toMinutes(diff);
		case "hours" : return tu.toHours(diff);
		case "days" : return tu.toDays(diff);
		default : return -1;
		
		}
		
	}
	
	
	
	public long Approx(long approx) {
		if(approx % 5 <= 3) {
			return approx / 5 * 5;
		} else {
			return (approx / 5 + 1) * 5;
		}
	}

	public boolean isOnline(Date lastOnlain) {
		Date dateNow = new Date();
		return TimeUnit.MILLISECONDS.toMinutes(dateNow.getTime() - lastOnlain.getTime()) <= 5;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(uuid, other.uuid);
	}

	


	public String toString() {
		return "User [userName=" + getUserName() + ", email=" + getEmail() + ", password=" + getPassword() + "]";
	}





	
	
	
	
	
}
