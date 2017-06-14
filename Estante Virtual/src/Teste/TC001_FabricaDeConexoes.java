/**
 * 
 */
package Teste;

import static org.junit.Assert.*;

import java.sql.*;

import org.junit.Test;

import Services.FabricaDeConexoes;

/**
 * @author Willian
 * Teste Inicial para validar a conexão com o Banco de dados Oracle 11g.
 */
public class TC001_FabricaDeConexoes {

	private Connection conexao;

	@Test
	public void test() {
		this.conexao = new FabricaDeConexoes().getConnection();
		System.out.println("Conexão Bem Sucedida!");
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
