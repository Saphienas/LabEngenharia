package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.sun.jmx.snmp.daemon.CommunicationException;


public class FabricaDeConexoes {
	Logger logger = Logger.getLogger(FabricaDeConexoes.class);
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String driver = "oracle.jdbc.OracleDriver";
	String usuario = "system";
	String senha = "Marli123";
	
	public FabricaDeConexoes (ConfiguraDB configura){
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}
	public FabricaDeConexoes(){
		
	}
	public Connection getConnection(){
		
		
		try {
			Class.forName(driver);
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			return (Connection) DriverManager.getConnection(url,usuario,senha);
			}
		catch (CommunicationException e){
			logger.info("Exceção de comunicacao com o DB causa: " + e.getMessage());
			
			throw new RuntimeException(e); 
		}
		catch (SQLException e){
			logger.info("Exceção geral causa SQLException: " + e.getMessage());
			
			throw new RuntimeException(e); 
		}
		catch (Exception e){
			logger.info("Exceção geral causa: " + e.getMessage());
			
			throw new RuntimeException(e); 
		}
	}
}

