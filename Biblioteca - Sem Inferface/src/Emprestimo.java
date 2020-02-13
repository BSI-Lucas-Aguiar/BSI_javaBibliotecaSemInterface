import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
	private int idEmprestimo;
	private String dadosAtendente;
	private Pessoa pessoa;
	private Acervo acervo;
	private double valorDia = 1;

	//Funcoes de manipulacao de Data - Para verificar se a multa funciona e necessario trocar - minus 14 no emprestimo, minus 7 na devolucao
	LocalDate dataEmp = LocalDate.now(); //Recebe a data de hoje para definir o dia inicial do emprestimo
	private String dataEmprestimo = dataEmp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	LocalDate dataDev = LocalDate.now().plusDays(7); //Recebe a data de hoje mais 7, ou seja devolucao em uma semana
	private String dataDevolucao = dataDev.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	LocalDate dataHoje = LocalDate.now(); //Recebe a data de hoje para comparacao na devolucao e geracao de multa
	
	//Construtor
	public Emprestimo(int idEmprestimo, String dadosAtendente) {
		this.idEmprestimo = idEmprestimo;
		this.dadosAtendente = dadosAtendente;
	}
	
	//Funcoes para realizacao do Emprestimo
	public int verificarDisponibilidade(Pessoa pessoa, Acervo acervo) { //Chamada pela realizar emprestimo, retorna se o emprestimo requerido e possivel
		if(this.pessoa.tipo.contentEquals("Professor")) {
			if(((Professor)pessoa).getSituacao().contentEquals("Liberado")&&((Acervo)acervo).getQtdEstoque()>=1) {
				((Professor)pessoa).alterarSituacao("Emprestimo Pendente");
				return 1;
			}
		}else if(this.pessoa.tipo.contentEquals("Aluno")) {
			if(((Aluno)pessoa).getSituacao().contentEquals("Liberado")&&((Acervo)acervo).getQtdEstoque()>=1) {
				((Aluno)pessoa).alterarSituacao("Emprestimo Pendente");
				return 1;
			}else {
				return 0;
			}
		}
		return 0;
	}
	
	public String realizarEmprestimo(Pessoa pessoa, Acervo acervo) { //A funcao pode receber aluno ou professor, a funcao verificarDisponibilidade opera conforme o tipo
		this.pessoa = pessoa;
		this.acervo = acervo;
		if(this.verificarDisponibilidade(this.pessoa, this.acervo)==1) {
			((Acervo)acervo).diminuirEstoque();
			return this.comprovanteEmprestimo();
		}else {
			return ("\n--Emprestimo Negado--\nLivro indisponivel ou Pessoa n�o liberada");
		}
	}
	
	//Imprime todas as informacoes pertinentes ao emprestimo
	public String comprovanteEmprestimo() {
		return ("\n--Comprovante de Emprestimo--\nID Emprestimo: "+ this.idEmprestimo + this.dadosAtendente + pessoa.dadosCadastrais() + acervo.dadosLivro()+"\nData de Emprestimo: "+dataEmprestimo+"\nData de Devolucao: "+dataDevolucao);
	}
	
	//Funcoes de devolucao de emprestimo
	public String realizarDevolucao(Pessoa pessoa, Acervo acervo) {
		acervo.aumentarEstoque();
		return (gerarMulta(pessoa, dataDev));
	}
	
        /*Polimorfismo*/
	public String gerarMulta(Pessoa pessoa, LocalDate dataDevolucao) { //Retorna uma multa por atraso, caso se faca necessario
		this.pessoa = pessoa;
		long diferencaEmDias = ChronoUnit.DAYS.between(dataHoje, dataDevolucao);
		
		if(this.pessoa.tipo.contentEquals("Professor")) {
			if(((Professor)pessoa).getSituacao().contentEquals("Emprestimo Pendente")) {
				if(dataHoje.isBefore(dataDevolucao)) {
					((Professor)pessoa).alterarSituacao("Liberado");
					return("\n--Livro devolvido com sucesso--");
				}else if((diferencaEmDias==0)){
					((Professor)pessoa).alterarSituacao("Liberado");
					return("\n--Livro devolvido com sucesso--");
				}else {
					((Professor)pessoa).alterarSituacao("Multa Pendente");
					double valorTotal;
					valorTotal = this.valorDia*diferencaEmDias;
					valorTotal=Math.abs(valorTotal);
					
					return ("\n--Livro devolvido com Multa--\nValor da Multa: "+valorTotal);
				}
			}
		}else if(this.pessoa.tipo.contentEquals("Aluno")) {
			if(((Aluno)pessoa).getSituacao().contentEquals("Emprestimo Pendente")) {
				if(dataHoje.isBefore(dataDevolucao)) {
					((Aluno)pessoa).alterarSituacao("Liberado");
					return("\n--Livro devolvido com sucesso--");
				}else if((diferencaEmDias==0)){
					((Aluno)pessoa).alterarSituacao("Liberado");
					return("\n--Livro devolvido com sucesso--");
				}else {
					((Aluno)pessoa).alterarSituacao("Multa Pendente");
					double valorTotal;
					valorTotal = this.valorDia*diferencaEmDias;
					valorTotal=Math.abs(valorTotal);
					
					return ("\n--Livro devolvido com Multa--\nValor da Multa: "+valorTotal);
				}
			}
		}
		return ("\nRetorno Secreto\n");
	}
	
	//Esta Funcao muda a situacao do cliente para liberado caso ele tenha pago a multa por atraso
	public String pagarMulta(Pessoa pessoa) {
		this.pessoa = pessoa;
		if(this.pessoa.tipo.contentEquals("Professor")) {
			if(((Professor)pessoa).getSituacao().contentEquals("Multa Pendente")) {
				((Professor)pessoa).alterarSituacao("Liberado");
				return ("\nMulta paga.\nRecebido por: "+this.dadosAtendente);
			}else {
				return ("\n\n--Multa--\nN�o h� multas pendentes para: "+pessoa.nome);
			}
		}else if(this.pessoa.tipo.contentEquals("Aluno")) {
			if(((Aluno)pessoa).getSituacao().contentEquals("Multa Pendente")) {
				((Aluno)pessoa).alterarSituacao("Liberado");
				return ("\nMulta paga.\nRecebido por: "+this.dadosAtendente);
			}else {
				return ("\n\n--Multa--\nN�o h� multas pendentes para: "+pessoa.nome);
			}			
		}
		return ("\n");
	}
	
}
