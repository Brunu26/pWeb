package exceptions;

public class UserNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "Usuario n�o foi Encontrado";
	}
	
}
