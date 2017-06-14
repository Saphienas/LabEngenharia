package Teste;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import Model.Exemplar;
import Services.ExemplarDao;

public class TC006_Abertura_de_Arquivos {

	@Test
	public void test() throws IOException {
		try{
		System.out.println("Abrindo sua HQ");
		java.awt.Desktop.getDesktop().open( new File( "WebContent/WEB-INF/Hqs/Wolverine - Velho Logan #01.pdf" ) ); 
		}
		catch(IllegalArgumentException e1){
			System.out.println(e1);
		}
	}

}
