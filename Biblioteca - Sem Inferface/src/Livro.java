/*Abstracao*/
public abstract class Livro {
	protected String titulo;
	protected int paginas;
	protected String genero;
	protected String dadosAutor;
	
	//Construtor
	public Livro(String titulo, int paginas, String genero, String dadosAutor) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.genero = genero;
		this.dadosAutor = dadosAutor;
	}
	
	//Retorna todas as informacoes do livro com excecao da quantidade em estoque, feita na classe acervo separadamente
	public String dadosLivro() {
		return ("\n--Livro--\nTitulo: "+this.titulo+"\nPaginas: "+this.paginas+"\nGenero: "+this.genero+this.dadosAutor);
	}
	
}
