package model.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Endereco {
	
	private static Logger logger = LoggerFactory.getLogger(Endereco.class);
	
	private String regiao;
	private String estado;
	private String cidade;
	private String rua;
	private double numero;
	
	public Endereco(String regiao,String estado,String cidade,String rua,double numero) {
		this.regiao = regiao;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getRegiao() {
		return regiao;
	}

	public String getEstado() {
		return estado;
	}

	public String getRua() {
		return rua;
	}

	public double getNumero() {
		return numero;
	}

	/**
	 * Fun��o com o objetivo de recuperar todos os dados do endere�o
	 * @return
	 */
	public String enderCompleto() {
		logger.info("Retornando o endere�o completo: {} {} {} {} {} ",regiao,estado,cidade,rua,numero);
		return "Regi�o: "+this.regiao+
				"\nEstado: "+this.estado+
				"\nCidade: "+this.cidade+
				"\nRua: "+this.rua+
				"\nNumero: "+this.numero;
	}
	
	/**
	 * Fun��o com o objetivo de recuperar dados do endere�o no entanto recuperando
	 * apenas a cidade, rua e o numero
	 * @return 
	 */
	public String enderCidade() {
		logger.info("Retornando a cidade, rua e o numero: {} {} {}",cidade,rua,numero);
		return "Cidade: "+this.cidade+
				"\nRua: "+this.rua+
				"\nNumero: "+this.numero;
		
	}
	
	/**
	 *Fun��o com o objetivo de recuperar dados do endere�o no entanto recuperando
	 *apenas a regi�o e o estado
	 * @return
	 */
	public String enderRegiao() {
		logger.info("Retornando a regi�o e o estado: {} {}",regiao,estado);
		return "Regi�o: "+this.regiao+
				"\nEstado: "+this.estado;
	}
}
