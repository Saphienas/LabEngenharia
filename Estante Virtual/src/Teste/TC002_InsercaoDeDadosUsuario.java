package Teste;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import Model.Exemplar;
import Services.ExemplarDao;


/**
 * @author Willian
 * Teste para inserção de dados sem validação.
 */

public class TC002_InsercaoDeDadosUsuario {

	@Test
	public void test() {
		
		//Calendar born = new GregorianCalendar(1997,0,15);
			
		 // Dados para a gravação
		 Exemplar exemplar = new Exemplar();
		 //exemplar.setId(3);
		 exemplar.setNome("Cronicas de Gelo e Fogo:Guerra dos Tronos");
		 exemplar.setEdicao(1);
		 exemplar.setPreco(40);
		 exemplar.setEditora("Leya");
		 exemplar.setAutor("George R.R Martin");
		 exemplar.setPaginasTotais(592);
		 exemplar.setPaginasAtuais(10);
		 
		 /* Conexao Utilizada */
		 ExemplarDao dao = new ExemplarDao();
		 
		 dao.AdicionaExemplar(exemplar);
		 
	}

}
