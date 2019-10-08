package controllers;

import java.sql.SQLException;

import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exceptions.AdminException;
import exceptions.UserNotFoundException;
import model.bean.User;
import model.dao.user.CreateUser;
import model.dao.user.DeleteUser;
import model.dao.user.UpdateUser;

public class ControllerUser {
	
	private static Logger logger = LoggerFactory.getLogger(ControllerUser.class); 
	
	/**
	 * Metodo para criação de usuario recebendo o user que sera o usuario a ser
	 * adicionado e o admin o usuario que ira adiciona-lo caso seja um administrador
	 * ira adiciona o usuario e retorna true caso não seja lanca uma exceção.
	 * @param user
	 * @param admin
	 * @return
	 * @throws SQLException
	 * @throws UserException
	 */
	public boolean create(User user, User admin) throws SQLException, AdminException {
		logger.info("Cadastrando Usuário");
		if(admin.isAdm()) {
			CreateUser.create(user);
			logger.info("Usuario Cadastrado");
			return true;
		}
		else {
			logger.info("Usuárioo é administrador");
			throw new AdminException();
		}
	}
	
	/**
	 * Metodo para deletar usuario recebendo o user que sera o usuario a ser
	 * deletado e o admin o usuario que ira deleta-lo caso seja um administrador
	 * ira deletar o usuario e retorna true caso não seja lanca uma exceção.
	 * @param user
	 * @param admin
	 * @return
	 * @throws SQLException
	 * @throws AdminException
	 */
	public boolean delete(User user, User admin) throws SQLException, AdminException {
		logger.info("Deletando Usuario");
		if(admin.isAdm()) {
			logger.info("Usuario Deletado com sucesso");
			DeleteUser.delete(user.getUsuario());
			return true;
		}else {
			logger.info("Usuario não é administrador");
			throw new AdminException();
		}
	}
	
	/**
	 * Metodo para selecionar usuario recebendo o user que sera o usuario a ser
	 * selecionado e o admin o usuario que ira seleciona-lo caso seja um administrador
	 * ira selecionar o usuario e retorna true caso não seja lanca uma exceção.
	 * @param user
	 * @param admin
	 * @return
	 * @throws SQLException
	 * @throws AdminException
	 */
	public boolean select(User user, User admin) throws SQLException, AdminException {
		logger.info("Selecionando Usuario");
		if(admin.isAdm()) {
			logger.info("Usuario Selecionado com sucesso");
			DeleteUser.delete(user.getUsuario());
			return true;
		}else {
			logger.info("Usuario não é administrador");
			throw new AdminException();
		}
	}
	
	/**
	 * Metodo para atualizar o usuario onde recebe o usuario que sera atualizado
	 * o admin que sera quem atualizar e os dados que atualizarao que sao o nome
	 * e a senha
	 * @param usuario
	 * @param admin
	 * @param nome
	 * @param senha
	 * @return
	 * @throws SQLException
	 * @throws AdminException
	 * @throws UserNotFoundException
	 */
	public boolean update(String usuario, User admin, String nome,String senha) throws SQLException, AdminException, UserNotFoundException {
		logger.info("Atualizando usuario");
		if(admin.isAdm()) {
			logger.info("Usuario Atualizado com sucesso");
			UpdateUser.update(usuario,nome,senha);
			return true;
		}else {
			logger.info("Usuario não é administrador");
			System.out.println("jiouhighg");
			throw new AdminException();
		}
	}
}
