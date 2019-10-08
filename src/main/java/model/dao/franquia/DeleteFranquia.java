package model.dao.franquia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.ConexaoBD;

public class DeleteFranquia {
	
	//Variavel para abrir conexão com o Banco de dados
	private Connection con = ConexaoBD.getConnection();
	
	/**
	 * Função para deletar a franquia recebendo o nome da mesma como metodo de pesquisa.
	 * Caso não seja encontrada retorno false caso contrario apago e registro e retorna true.
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String nome) throws SQLException {
		//Pesquisa no banco a franquia pelo nome
		String sql = "Select idfranquia from franquia where nome=?";
		PreparedStatement stmt = con.prepareStatement(sql);  
		stmt.setString(1, nome);
		ResultSet rs =  stmt.executeQuery();
		while(rs.next()) {
			//Sendo encontrada deleta das tabelas franquia e endereco seu registro
			sql = "DELETE franquia.*, endereco.*"
					+ " FROM franquia, endereco"
					+ " Where franquia.idfranquia = ?"
					+ " AND franquia.idfranquia=endereco.idfranquia";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, rs.getInt(1));
			stmt.executeUpdate();
			stmt.close();
			return true;
		}
		return false;
	}
}
