package model.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Franquia {
	
	private static Logger logger = LoggerFactory.getLogger(Franquia.class);
	
	private int id;
	private Endereco endereco;
	private String nome;
	private boolean matriz;
	/**
	 * Variaveis referente a franquias proximas
	 */
	private String fr1,fr2,fr3;
	private float km1,km2,km3;

	public Franquia(String nome, Endereco endereco, boolean matriz) {
		this.nome = nome;
		this.matriz = matriz;
		this.endereco = endereco;
	}

	/**
	 * Função criada com o proposito de retorna o endero de cada franquia onde pode
	 * escolher entre uma versão resumida ou cada parte do endereço
	 * (região,cidade,estado,rua,numero)
	 * 
	 * @return
	 */

	public Endereco getEndereco() {
		logger.info("Retornando o Endereço da Franquia: {}", endereco.enderCompleto());
		return endereco;
	}

	public int getId() {
		logger.info("Retornando o Id da Franquia: {}",id);
		return id;
	}

	public boolean isMatriz() {
		logger.info("Verificando se a Franquia é matriz: {}",matriz);
		return matriz;
	}

	public String getNome() {
		logger.info("Retornando o Nome da Franquia: {}",nome);
		return this.nome;
	}

}
