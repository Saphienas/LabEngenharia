package Teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Model.Exemplar;
import Services.ExemplarDao;

public class TC007_ConsultaDeDadosLista {

	@Test
	public void test() {
		
		ExemplarDao dao = new ExemplarDao();
		List<Exemplar> exemplares = dao.getLista();
		
		for (Exemplar exemplar : exemplares) {
			System.out.println("Nome: " + exemplar.getNome());
		}
	}

}
