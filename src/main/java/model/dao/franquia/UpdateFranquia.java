package model.dao.franquia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.ConexaoBD;
import exceptions.FranquiaNotFoundException;

public class UpdateFranquia {
	
	//Variavel para abrir conexão com o Banco de dados
	private Connection con = ConexaoBD.getConnection();
	
	/**
	 * Metodo para alterar nome da franquia recebendo o nomep(nome para pesquisar)
	 * e nomea (nome para que vai ser alterado) encontrando altera o seu nome 
	 * e retorna true caso contrario retorna falso
	 * @param nomep
	 * @param nomea
	 * @return
	 * @throws SQLException
	 * @throws FranquiaNotFoundException 
	 */
	public boolean updateNome(String nomep, String nomea) throws SQLException, FranquiaNotFoundException {

		//Pesquisa no banco a franquia pelo nome
		String sql = "Select idfranquia from franquia where nome=?";
		PreparedStatement stmt = con.prepareStatement(sql);  
		stmt.setString(1, nomep);
		ResultSet rs =  stmt.executeQuery();
		while(rs.next()) {
			sql = "UPDATE franquia SET nome=? where idfranquia=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nomea);
			stmt.setInt(2, rs.getInt("idfranquia"));
			stmt.executeUpdate();
			stmt.close();
			return true;
		}
		throw new FranquiaNotFoundException();
	}
	
}
