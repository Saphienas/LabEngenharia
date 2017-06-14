package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Exemplar;
import Services.ExemplarDao;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	                    throws ServletException, IOException{
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "Controller." + parametro;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);
		} catch (ClassNotFoundException e) {
			throw new ServletException("A Lógica de negócio causou um execeção!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

