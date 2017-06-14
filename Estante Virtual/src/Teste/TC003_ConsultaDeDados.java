package Teste;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Exemplar;
import Services.ExemplarDao;

public class TC003_ConsultaDeDados {

	@Test
	public void test() {
		Exemplar exemplar = new Exemplar(); 
		
		ExemplarDao dao = new ExemplarDao();
		 
		dao.ConsultaExemplar(exemplar);
	}

}
