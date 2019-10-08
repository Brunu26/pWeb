package model.dao.franquia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.ConexaoBD;
import model.bean.Endereco;
import model.bean.Franquia;

public class SelectFranquia {
	
	//Variavel para abrir conexão com o Banco de dados
	private Connection con = ConexaoBD.getConnection();
	private Franquia franquia;
	private Endereco endereco;
	
	/**
	 * Metodo de pesquisa da franquia recebendo o nome da mesma
	 * retornando todos os dados da franquia e seu endereço
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	public Franquia select(String nome) throws SQLException {

		//Pesquisa no banco a franquia pelo nome
		String sql = "Select * from franquia f,endereco e where nome=? and e.idfranquia=f.idfranquia";
		PreparedStatement stmt = con.prepareStatement(sql);  
		stmt.setString(1, nome);
		ResultSet rs =  stmt.executeQuery();
		while(rs.next()) {
			String name = rs.getString("nome");
			boolean matriz = rs.getBoolean("matriz");
			String rua = rs.getString("rua");
			String cidade = rs.getString("cidade");
			String estado = rs.getString("estado");
			String regiao = rs.getString("regiao");
			int numero = rs.getInt("numero");
			endereco = new Endereco(regiao, estado, cidade, rua, numero);
			franquia = new Franquia(name, endereco, matriz);
		}
		return franquia;
	}
	
}
