package model.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	
	private static Logger logger = LoggerFactory.getLogger(User.class);
	
	private String nome;
	
	private String usuario;
	
	private String senha;
	
	private int idFranquia;
	
	private boolean adm;

	public User(String nome, String usuario, String senha, int idFranquia, boolean adm) {
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.idFranquia = idFranquia;
		this.adm = adm;
	}
	
	public User(String nome, String usuario, int idFranquia, boolean adm) {
		this.nome = nome;
		this.usuario = usuario;
		this.idFranquia = idFranquia;
		this.adm = adm;
	}
	
	public String getNome() {
		logger.info("Retornando o nome do usu�rio: {}", nome);
		return nome;
	}

	public String getUsuario() {
		logger.info("Login do Usu�rio: {}", usuario);
		return usuario;
	}

	public String getSenha() {
		logger.info("Retornando a senha do usu�rio: {}", senha);
		return senha;
	}

	public int getIdFranquia() {
		logger.info("Retornando o id da franquia: {}", idFranquia);
		return idFranquia;
	}

	public boolean isAdm() {
		logger.info("Verificando se o usu�rio � Adm: {}",adm);
		return adm;
	}
	
	
	
}
