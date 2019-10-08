package model.dao.encomenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllers.ConexaoBD;

public class DeleteEncomenda {

	private static Connection con = new ConexaoBD().getConnection();
	
	public static void delete() throws SQLException {
		String sql = "DELETE FROM encomenda Where idencomenda!='a'";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.executeUpdate();
		stmt.close();
	}
}
