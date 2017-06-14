package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Exemplar;

public class ExemplarDao {
	private Connection conexao;
	
	public ExemplarDao (){
		this.conexao = new FabricaDeConexoes().getConnection();
	}
	
	public void AdicionaExemplar(Exemplar exemplar){
		String sql = "insert into Estante" + "(BookId,BookName,BookEdition,BookPrice"
				+ ",BookPublisher,BookAuthor,BookTotalPages,BookCurrentPages)"+
				"values(idBook.nextval,?, ?, ?, ?, ?, ?, ?)";
		
		try{
			
			/* Statement para a inserção de dados no BD */
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			/* Setando os Valores nos seus devidos "?" */
			//stmt.setInt(1, exemplar.getId());
			stmt.setString(1, exemplar.getNome());
			stmt.setInt(2, exemplar.getEdicao());
			stmt.setDouble(3,exemplar.getPreco());
			stmt.setString(4,exemplar.getEditora());
			stmt.setString(5, exemplar.getAutor());
			stmt.setInt(6,exemplar.getPaginasTotais());
			stmt.setInt(7,exemplar.getPaginasAtuais());

			/* Executa a DAO */
			stmt.execute();
			stmt.close();
			
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
	}
	
	public void ExcluiExemplar(Exemplar exemplar){
		String sql = "delete from Estante" + " where "+"BookId = ?";
		
		try{
			
			/* Statement para a exclusão de dados no BD */
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			/* Setando os Valores nos seus devidos "?" */
			stmt.setInt(1, exemplar.getId());

			/* Executa a DAO */
			stmt.execute();
			stmt.close();
			
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
	}
	
	public void AlteraExemplar(Exemplar exemplar){
		String sql = "update Estante set " + "BookId = ?,BookName = ?,BookEdition = ?,BookPrice = ?"
				+ ",BookPublisher = ?,BookAuthor = ?,BookTotalPages = ?,BookCurrentPages = ?"+"where "+"BookId = 3";
		
		try{
			
			/* Statement para a alteração de dados no BD */
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			/* Setando os Valores nos seus devidos "?" */
			stmt.setInt(1, exemplar.getId());
			stmt.setString(2, exemplar.getNome());
			stmt.setInt(3, exemplar.getEdicao());
			stmt.setDouble(4,exemplar.getPreco());
			stmt.setString(5,exemplar.getEditora());
			stmt.setString(6, exemplar.getAutor());
			stmt.setInt(7,exemplar.getPaginasTotais());
			stmt.setInt(8,exemplar.getPaginasAtuais());

			/* Executa a DAO */
			stmt.execute();
			stmt.close();
			
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
	}
	
	public void AlteraCampo(Exemplar exemplar){
		String sql = "update Estante set " + "BookCurrentPages = ?"+"where "+"BookId = ?";
		
		try{
			
			/* Statement para a alteração de dados no BD */
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			/* Setando os Valores nos seus devidos "?" */
			stmt.setInt(2, exemplar.getId());
			stmt.setInt(1,exemplar.getPaginasAtuais());

			/* Executa a DAO */
			stmt.execute();
			stmt.close();
			
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
	}
	
	public void ConsultaExemplar(Exemplar exemplar){
		
		String sql = "select * from Estante";
		
		//Função sujeita a mudança para Listagem
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//Função para a execução Coluna/Coluna do BD
			ResultSet consulta =  stmt.executeQuery();
			
			while(consulta.next()){
				
				int id = consulta.getInt("BookId");
				String nome = consulta.getString("BookName");
				int edition = consulta.getInt("BookEdition");
				double price = consulta.getDouble("BookPrice");
				String publisher = consulta.getString("BookPublisher");
				String author = consulta.getString("BookAuthor");
				int totalPages = consulta.getInt("BookTotalPages");
				int currentPages = consulta.getInt("BookCurrentPages");
				
				System.out.println(id + " || "+ nome + " || "
						+edition+ " || "+price+ " || "+publisher+ " || "
						+author+ " || "+totalPages+ " || "+currentPages);
			}		
			stmt.close();
			conexao.close();
			
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		
	}

	public List <Exemplar> getLista(){
		try{
			 List<Exemplar> Exemplares = new ArrayList<Exemplar>();
			 PreparedStatement stmt = this.conexao.prepareStatement("select * from Estante");
			 ResultSet rs = stmt.executeQuery();
			 while(rs.next()){
				 // criando o objeto Contato
				 Exemplar exemplar = new Exemplar();
				 exemplar.setId(rs.getInt("BookId"));
				 exemplar.setNome(rs.getString("BookName"));
				 exemplar.setEdicao(rs.getInt("BookEdition"));
				 exemplar.setPreco(rs.getDouble("BookPrice"));
				 exemplar.setEditora(rs.getString("BookPublisher"));
				 exemplar.setAutor(rs.getString("BookAuthor"));
				 exemplar.setPaginasTotais(rs.getInt("BookTotalPages"));
				 exemplar.setPaginasAtuais(rs.getInt("BookCurrentPages"));
				 
				 Exemplares.add(exemplar);				 
			 }
			 
			 rs.close();
			 stmt.close();
			 return Exemplares;
		}catch(SQLException e){
			throw new RuntimeException(e);

		}
	}
	
}
