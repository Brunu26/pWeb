package model.dao.encomenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllers.ConexaoBD;
import model.bean.Encomenda;
import model.bean.Franquia;

public class CreateEncomenda {

	private static Connection con = new ConexaoBD().getConnection();

	/**
	 * Método para criar uma encomenda no banco de dados, onde serão informados os 
	 * id dos remetentes, destinatarios e o endereço de entrega da encomenda.
	 * @param enc
	 * @param fra
	 * @return
	 * @throws SQLException
	 */
	public static boolean create(Encomenda enc, Franquia reme, Franquia dest) throws SQLException {
		String sql = "INSERT INTO ENCOMENDA (idencomenda,idfranquia_remetente,idfranquia_destinatario,endereco) VALUES(?,?,?,?)";

		PreparedStatement stmt = null;

		stmt = con.prepareStatement(sql);

		stmt.setString(1, enc.getIdentificador());
		stmt.setInt(2, reme.getId());
		stmt.setInt(3, dest.getId());
		stmt.setString(4, enc.getEndereco().enderCompleto());
		stmt.executeUpdate();


		return true;
	}

}
