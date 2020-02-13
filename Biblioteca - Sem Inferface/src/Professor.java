/*Herança*/
public class Professor extends Pessoa {
	private String matricula;
	private String situacao;
	
	//Construtor
	public Professor(String nome, String sexo, String endereco, String telefone, String tipo,
			String matricula, String situacao) {
		super(nome, sexo, endereco, telefone, tipo);
		this.matricula = matricula;
		this.situacao = situacao;
	}
	
	//Sets & Gets Usados para modifica��o no Empr�stimo
	public String getSituacao() {
		return situacao;
	}
	
	//Retorna as informacoes de um Professor, inclusive sua situacao
        @Override
	public String dadosCadastrais() {
		return ("\nTipo de Cliente: Professor"+"\nMatricula: "+this.matricula+"\nSituacao: "+this.situacao+super.dadosCadastrais());
	}
	
	//Utilizada para alterar a situacao do Professor. Ex: Liberado, Multa Pendente, Emprestimo Pendente
	public void alterarSituacao(String altera) {
		this.situacao = altera;
	}
}
