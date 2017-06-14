package Teste;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Exemplar;
import Services.ExemplarDao;

public class TC005_ExclusaoDeDados2 {

	@Test
	public void test() {
		Exemplar exemplar = new Exemplar(); 
		exemplar.setId(1);
		ExemplarDao dao = new ExemplarDao();
		 
		dao.ExcluiExemplar(exemplar);
	}

}
