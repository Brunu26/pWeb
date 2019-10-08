package model.bean;

public class Encomenda {
	
	private String identificador;
	private Franquia remetente;
	private Franquia destinatario;
	private Endereco endereco;
	
	public Encomenda(String identificador, Franquia remetente, Franquia destinatario, Endereco endereco) {
		this.identificador = identificador;
		this.destinatario = destinatario;
		this.remetente = remetente;
		this.endereco = endereco;
		this.identificador = identificador;		
	}

	public String getIdentificador() {
		return identificador;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	
}
