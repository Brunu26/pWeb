package exceptions;

public class AdminException extends Exception{

	@Override
	public String getMessage() {
		return "Usuario não é administrador";
	}
	
}
