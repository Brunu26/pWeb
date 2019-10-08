package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConexaoBD {

	private static Logger logger = LoggerFactory.getLogger(ConexaoBD.class);
	
	private static String user = "root";
	private static String pass = "";
	
    public static Connection getConnection(){
        try{
        	logger.error("conectando à base de dados");
            return DriverManager.getConnection("jdbc:mysql://localhost/TPO?useTimezone=true&serverTimezone=UTC",user,pass);
        }
        catch(SQLException e){
        	logger.error(e.getMessage());
        	logger.error("erro na conexão",e);
            System.out.println("Problemas na conexao com o banco de dados."+e);
        }
        return null;
    } 
	
}
