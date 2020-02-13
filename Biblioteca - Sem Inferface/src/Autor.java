
public class Autor {
	private String nome;
	
	//Construtor, possui somente o nome do autor que será enviado para o livro em sua criacao
	public Autor(String nome) {
		this.nome = nome;
	}
	
	//Entrega o nome do autor para a Funcao que o solicitou, utilizado pelo livro
	public String dadosAutor() {
		return ("\nAutor: "+this.nome);
	}
}
