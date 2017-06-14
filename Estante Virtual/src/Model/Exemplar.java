package Model;

public class Exemplar {
	
	private String nome;
	private int edicao;
	private double preco;
	private String editora;
	private String autor;
	private int paginasTotais;
	private int paginasAtuais;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getEdicao() {
		return edicao;
	}
	
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getPaginasTotais() {
		return paginasTotais;
	}
	
	public void setPaginasTotais(int paginasTotais) {
		this.paginasTotais = paginasTotais;
	}
	
	public int getPaginasAtuais() {
		return paginasAtuais;
	}
	
	public void setPaginasAtuais(int paginasAtuais) {
		this.paginasAtuais = paginasAtuais;
	}
		
}
