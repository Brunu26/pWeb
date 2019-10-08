package model.dao.encomenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.ConexaoBD;
import exceptions.EncomendNotFoundException;

public class SelectEncomenda {
	
	private static Connection con = new ConexaoBD().getConnection();

	public static boolean select(String identificador) throws SQLException, EncomendNotFoundException{
		
		String sql = "SELECT * FROM encomenda WHERE idEncomenda = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, identificador);
		ResultSet rs = stmt.executeQuery();
		if(rs !=null && rs.next()) {
			return true;
		}
		throw new EncomendNotFoundException();
	}
}
