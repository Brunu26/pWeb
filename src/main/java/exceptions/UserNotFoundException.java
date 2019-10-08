package exceptions;

public class UserNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "Usuario não foi Encontrado";
	}
	
}
