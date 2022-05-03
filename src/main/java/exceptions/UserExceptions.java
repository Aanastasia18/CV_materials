package exceptions;

public class UserExceptions extends Exception{
	
	public String InvalidUserDobException() {
		return "Incorrect date of birthday!!!";
	}

	public String InvalidUserEmailException() {
		return "Incorrect email addess!!!";
	}
	
	public String InvalidUserNameException() {
		return "Incorrect user name!!!";
	}
	
	public String InvalidUserPasswordException() {
		return "Incorrect password!!!";
	}
	
	public String InvalidUserRealException() {
		return "Incorrect reality value!!!";
	}
	

}
