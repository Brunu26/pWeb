package exceptions;

public class FranquiaNotFoundException extends Exception {
	@Override
	public String getMessage() {
		return "Franquia n�o foi Encontrada";
	}
}
