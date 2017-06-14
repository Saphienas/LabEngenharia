package Controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ExemplarDao;
import Model.Exemplar;
public class DeletaExemplarLogic implements Logica {
	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Exemplar cont = new Exemplar();
		ExemplarDao dao = new ExemplarDao();
		int id = Integer.parseInt(req.getParameter("id"));
		cont.setId(id);
		dao.ExcluiExemplar(cont);
        RequestDispatcher rd = req.getRequestDispatcher("/Consulta.jsp");
		rd.forward(req, res);
	}
}