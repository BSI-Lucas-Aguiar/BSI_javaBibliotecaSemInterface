/*Herança*/
public class Aluno extends Pessoa {
	private String matricula;
	private String situacao;
	
	//Construtor
	public Aluno(String nome, String sexo, String endereco, String telefone, String tipo, String matricula,
			String situacao) {
		super(nome, sexo, endereco, telefone, tipo);
		this.matricula = matricula;
		this.situacao = situacao;
	}
	
	//Somente get para consulta no emprestimo
	public String getSituacao() {
		return situacao;
	}

	//Retorna as informacoes de um Aluno, inclusive sua situacao
        @Override
	public String dadosCadastrais() {
		return ("\nTipo de Cliente: Aluno"+"\nMatricula: "+this.matricula+"\nSituacao: "+this.situacao+super.dadosCadastrais());
	}
	
	//Utilizada para alterar a situacao do aluno. Ex: Liberado, Multa Pendente, Emprestimo Pendente
	public void alterarSituacao(String altera) {
		this.situacao = altera;
	}
}
