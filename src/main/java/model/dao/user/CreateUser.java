package model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.ConexaoBD;
import exceptions.AdminException;
import model.bean.User;

public class CreateUser {
	
	//Variavel para conexão com Banco de dados
	private static Connection con = new ConexaoBD().getConnection();
	
	/**
	 * Metodo para criar usuarios no banco de dados inserindo seu nome,
	 * usuario, senha, idfranquia a qual esta associado e se é administrador
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public static void create(User user) throws SQLException {
		String sql = "Insert into users(nome,usuario,senha,idfranquia,adm)"
				+ "Values (?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getNome());
		stmt.setString(2, user.getUsuario());
		stmt.setString(3, user.getSenha());
		stmt.setInt(4, user.getIdFranquia());
		stmt.setBoolean(5, user.isAdm());
		
		stmt.executeUpdate();		
		stmt.close();
	}
}
