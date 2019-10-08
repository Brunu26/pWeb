package model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.ConexaoBD;

public class DeleteUser {
	
		//Variavel para abrir conexão com o Banco de dados
		private static Connection con = ConexaoBD.getConnection();
		
		/**
		 * Função para deletar o user recebendo como parametro o usuario e fazendo uma pesquisa
		 * retornando verdadeiro e deletando quando encontrado e retornando falso quando não encontrado
		 * nos registros
		 * @param usuario
		 * @return
		 * @throws SQLException
		 */
		public static boolean delete(String usuario) throws SQLException {
			//Pesquisa no banco a franquia pelo nome
			String sql = "Select idusers from users where usuario=?";
			PreparedStatement stmt = con.prepareStatement(sql);  
			stmt.setString(1, usuario);
			ResultSet rs =  stmt.executeQuery();
			while(rs.next()) {
				//Sendo encontrada deleta o registro do usuario
				sql = "DELETE FROM users Where idusers = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, rs.getInt(1));
				stmt.executeUpdate();
				stmt.close();
				return true;
			}
			return false;
		}
	
}
