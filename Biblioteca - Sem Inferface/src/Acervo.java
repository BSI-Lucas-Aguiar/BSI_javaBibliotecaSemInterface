/*Herança*/
public class Acervo extends Livro{
	private int qdtEstoque;

	//Construtor
	public Acervo(String titulo, int paginas, String genero, String dadosAutor, int qdtEstoque) {
		super(titulo, paginas, genero, dadosAutor);
		this.qdtEstoque = qdtEstoque;
	}
	
	//Possui somente o getQtdEstoque, pois, sera utilizado para controle de estoque
	public int getQtdEstoque() {
		return this.qdtEstoque;
	}
	
	//Funcoes para alteracoes no estoque
	public void diminuirEstoque() {
		if(this.qdtEstoque>=1)
			this.qdtEstoque -= 1;
	}
	
	public void aumentarEstoque() {
		this.qdtEstoque += 1;
	}
	
	//Retorna os dados do livro
	public String dadosLivro() {
		return super.dadosLivro();
	}
}
