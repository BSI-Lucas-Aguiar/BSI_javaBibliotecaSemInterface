/*Abstracao*/
public abstract class Pessoa {
	protected String nome;
	protected String sexo;
	protected String endereco;
	protected String telefone;
	protected String tipo;
	
	//Construtor
	public Pessoa(String nome, String sexo, String endereco, String telefone, String tipo) {
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
		this.telefone = telefone;
		this.tipo = tipo;
	}
	
	//Retorna os dados cadastrais de uma pessoa, e utilizada por professor e aluno para imprimir o cadastro completo
	public String dadosCadastrais() {
		return ("\nNome: "+this.nome+"\nSexo: "+this.sexo+"\nTelefone: "+this.telefone);
	}
	
}
