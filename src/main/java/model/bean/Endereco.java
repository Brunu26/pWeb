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
	 * Função com o objetivo de recuperar todos os dados do endereço
	 * @return
	 */
	public String enderCompleto() {
		logger.info("Retornando o endereço completo: {} {} {} {} {} ",regiao,estado,cidade,rua,numero);
		return "Região: "+this.regiao+
				"\nEstado: "+this.estado+
				"\nCidade: "+this.cidade+
				"\nRua: "+this.rua+
				"\nNumero: "+this.numero;
	}
	
	/**
	 * Função com o objetivo de recuperar dados do endereço no entanto recuperando
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
	 *Função com o objetivo de recuperar dados do endereço no entanto recuperando
	 *apenas a região e o estado
	 * @return
	 */
	public String enderRegiao() {
		logger.info("Retornando a região e o estado: {} {}",regiao,estado);
		return "Região: "+this.regiao+
				"\nEstado: "+this.estado;
	}
}
