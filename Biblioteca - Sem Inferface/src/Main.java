
public class Main {

	public static void main(String[] args) {
		//Cadastrando e imprimindo dados de um Atendente
		Atendente atendente1 = new Atendente("Paulo", "Masculino", "Rua da Biblioteca - 1", "666-666-666", "Atendente", 001);
		System.out.println(atendente1.dadosCadastrais());
		
		//Cadastrando e imprimindo dados de um Professor
		Professor professor1 = new Professor("Renata Mesquita", "Feminino", "Rua Logo ali", "222-222-222", "Professor", "123412341234", "Liberado");
		System.out.println(professor1.dadosCadastrais());
		
		//Cadastrando e imprimindo dados de um Aluno
		Aluno aluno1 = new Aluno("Amarildo Junior", "Masculino", "Longe pra caramba", "111-111-111", "Aluno", "223322332233", "Liberado");
		System.out.println(aluno1.dadosCadastrais());
		
		//Cadastrando um Autor
		Autor autor1 = new Autor("JRR Tolkien");
		System.out.println(autor1.dadosAutor());
		
		//Cadastrando um Acervo, que herda de livros e manipula seu estoque
		Acervo acervo1 = new Acervo("O Hobbit", 310, "Fantasia", autor1.dadosAutor(), 1);
		System.out.println(acervo1.dadosLivro()+"\nQuantidade no Estoque: "+acervo1.getQtdEstoque());
		
		//Realizando um emprestimo para o Aluno1
		Emprestimo emprestimo1 = new Emprestimo(1, atendente1.dadosCadastrais());
		System.out.println("\nEmprestimo para Aluno:"+ emprestimo1.realizarEmprestimo(aluno1, acervo1));
		System.out.println("\nAluno apos ter feito emprestimo:"+aluno1.dadosCadastrais());
		System.out.println("\nAcervo apos emprestimo: "+acervo1.getQtdEstoque());
		
		//Realizando Emprestimo para o Professor1 - Falha por falta de estoque
		Emprestimo emprestimo2 = new Emprestimo(2, atendente1.dadosCadastrais());
		System.out.println("\nTeste Emprestimo Professor, deve falhar:"+ emprestimo2.realizarEmprestimo(professor1, acervo1));		
		
		
		System.out.println("\nRealizando a devolucao do aluno 1:"+emprestimo1.realizarDevolucao(aluno1, acervo1));
		System.out.println("\nAcervo apos devolucao: "+acervo1.getQtdEstoque());
		System.out.println("\nAluno apos ter devolvido o livro"+aluno1.dadosCadastrais());
		
		//Operacoes para o caso de devolucao com multa
		//System.out.println("\nTeste Pagamento de multa:"+emprestimo1.pagarMulta(aluno1));
		//System.out.println("\nAluno apos ter pago a multa"+aluno1.dadosCadastrais());
				
		//Ap�s a devolucao do aluno1
		System.out.println("\nTeste Emprestimo Professor, deve funcionar, pois ja foi devolvido:"+ emprestimo2.realizarEmprestimo(professor1, acervo1));		

		
		
	}

}
