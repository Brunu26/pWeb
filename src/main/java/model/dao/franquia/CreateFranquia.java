package model.dao.franquia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controllers.ConexaoBD;
import model.bean.Franquia;

public class CreateFranquia {
	
	//Variavel para abrir conex�o com o Banco de dados
	private Connection con = ConexaoBD.getConnection();
	
	private static Logger logger = LoggerFactory.getLogger(CreateFranquia.class);
	
	/**
	 * Fun��o para salvar a franquia no banco de dados, nela recupero os dados da model franquia
	 * e endere�o e salvo em suas respectivas tabelas (franquia e endere�o).
	 * Retornando true para quando cadastrar e false para quando j� existir uma Franquia na cidade
	 * @param nome
	 * @param matriz
	 * @return
	 * @throws Exception
	 */
	public boolean create(Franquia franquia) throws Exception {	
		/**
		 * Recupera��o e verifica��o se existe alguma franquia na cidade
		 * caso exista ele n�o ir� salvar.
		 */
		logger.info("criando franquia");
		String sql = "Select idfranquia from endereco where cidade=?";
		PreparedStatement stmt = con.prepareStatement(sql);  
		stmt.setString(1, franquia.getEndereco().getCidade());
		ResultSet rs =  stmt.executeQuery();
		boolean verifi = true;
		while(rs.next()&& rs!=null) {
			verifi = false;
		}
		if(verifi) {
			//Inserindo a Franquia no banco de dados
			//Inicio
			String sqlFranquia = "INSERT INTO franquia(nome,matriz) VALUES(?,?)";
			stmt = con.prepareStatement(sqlFranquia,Statement.RETURN_GENERATED_KEYS);  
	
	        stmt.setString(1, franquia.getNome());  
	        stmt.setBoolean(2, franquia.isMatriz());    
	
	        stmt.executeUpdate();
	        //Fim
	        
	        //Recupera��o do id em que foi salvo a franquia
	        //Inicio
	        ResultSet keys = stmt.getGeneratedKeys();
	
	        int key = 0;
	      	if( keys.next()) {
	    	   key =keys.getInt(1);
	      	}
	        //Fim
	      	
	      	//Inserindo endere�o com a id do mesmo valor da franquia inserida
	      	//Inicio
	        stmt = con.prepareStatement("insert into endereco (regiao, estado, cidade, rua, numero, idfranquia) " 
	                + " values(?, ?, ?, ?, ?, ?)");
	
	        stmt.setString(1, franquia.getEndereco().getRegiao()); 
	        stmt.setString(2, franquia.getEndereco().getEstado()); 
	        stmt.setString(3, franquia.getEndereco().getCidade()); 
	        stmt.setString(4, franquia.getEndereco().getRua()); 
	        stmt.setDouble(5, franquia.getEndereco().getNumero()); 
	        stmt.setInt(6, key); 
	        stmt.execute();
	        //Fim
	        
	        //Finalizando conex�o
	        stmt.close();
	        return true;
		}
		return false;
	}
}
