package model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.ConexaoBD;
import exceptions.UserNotFoundException;

public class UpdateUser {
	
	//Variavel para abrir conexão com o Banco de dados
	private static Connection con = ConexaoBD.getConnection();
	
	/**
	 * Metodo no qual atualiza o registro do usuario alterando seu nome e/ou senha
	 * é feito uma pesquisa no banco de dados atrás do usuario caso seja encontrado
	 * altera seus parametros e retorna verdadeiro caso não seja retorna falso.
	 * @param usuario
	 * @param senha
	 * @param nome
	 * @return
	 * @throws SQLException
	 * @throws UserNotFoundException 
	 */
	public static boolean update(String usuario, String senha, String nome) throws SQLException, UserNotFoundException {
		String sql = "Select idusers from users where usuario=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, usuario);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			sql = "UPDATE users SET nome=?, senha=? where idusers=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			stmt.setInt(3, rs.getInt("idusers"));
			stmt.executeUpdate();
			return true;
		}
		throw new UserNotFoundException();
	}
	
}
