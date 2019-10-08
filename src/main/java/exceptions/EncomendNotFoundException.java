package exceptions;

public class EncomendNotFoundException extends Exception{

	@Override
	public String getMessage() {
		return "Encomenda não foi Encontrada";
	}
	
}
