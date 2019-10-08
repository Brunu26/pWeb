package model.dao.franquia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.ConexaoBD;

public class DeleteAll {
	
	//Variavel para abrir conexão com o Banco de dados
	private static Connection con = ConexaoBD.getConnection();
	
	/**
	 * Função para limpar banco de dados par os testes
	 * @return
	 * @throws SQLException
	 */
	public static void delete() throws SQLException {
		String sql = "DELETE From franquia where nome!='oi'";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.executeUpdate();
		stmt.close();
	
	}
}
