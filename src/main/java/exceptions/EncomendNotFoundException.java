package exceptions;

public class EncomendNotFoundException extends Exception{

	@Override
	public String getMessage() {
		return "Encomenda n�o foi Encontrada";
	}
	
}
