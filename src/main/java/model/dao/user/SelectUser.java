package model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.ConexaoBD;
import exceptions.UserNotFoundException;
import model.bean.User;

public class SelectUser {
	
	//Variavel para abrir conexão com o Banco de dados
	private static Connection con = ConexaoBD.getConnection();
	private static User user;
	
	/**
	 * Metodo que recebe o usuario e faz uma pesquisa achando retornar todos os seus dados
	 * menos a senha, não encontrando retorna um user vazio.
	 * @param usuario
	 * @return
	 * @throws SQLException
	 * @throws UserNotFoundException 
	 */
	public static User select(String usuario) throws SQLException, UserNotFoundException {
		//Pesquisa no banco o user pelo usuario
		String sql = "Select * from user where usuario=?";
		PreparedStatement stmt = con.prepareStatement(sql);  
		stmt.setString(1, usuario);
		ResultSet rs =  stmt.executeQuery();
		while(rs.next()) {
			String nome = rs.getString("nome");
			boolean adm = rs.getBoolean("adm");
			int idFranquia = rs.getInt("idfranquia");
			user = new User(nome, usuario, idFranquia, adm);
		}
		if(rs==null) {
			throw new UserNotFoundException();
		}else {
			return user;
		}
	}
	
}
