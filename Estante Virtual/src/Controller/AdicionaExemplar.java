package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Exemplar;
import Services.ExemplarDao;

@WebServlet ("/exemplarController")
public class AdicionaExemplar extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String acao = request.getParameter("Metodo");
		ExemplarDao dao = new ExemplarDao();
		
		if(acao.equals("AdicionaExemplar")){
			String nome = request.getParameter("nome");
			int edicao = Integer.parseInt(request.getParameter("edicao"));
			double preco = Double.parseDouble(request.getParameter("preco"));
			String editora = request.getParameter("editora");
			String autor = request.getParameter("autor");
			int totalP = Integer.parseInt(request.getParameter("totalP"));
			int atualP = Integer.parseInt(request.getParameter("atualP"));
			
			Exemplar exemplar = new Exemplar();
			
			exemplar.setNome(nome);
			exemplar.setEdicao(edicao);
			exemplar.setPreco(preco);
			exemplar.setEditora(editora);
			exemplar.setAutor(autor);
			exemplar.setPaginasTotais(totalP);
			exemplar.setPaginasAtuais(atualP);
			//exemplar.setId(1);
			
			dao.AdicionaExemplar(exemplar);
			
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
            out.println("<body>");
            out.println("Contato " + exemplar.getNome() + 
                    " adicionado com sucesso");    
            out.println("</body>");
            out.println("</html>");
			
		}
		
	}
	
}
		          
		
		
		
		
