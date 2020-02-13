
public class Atendente extends Pessoa {
	private int idAtendente;
	
	//Construtor
	public Atendente(String nome, String sexo, String endereco, String telefone, String tipo, int idAtendente) {
		super(nome, sexo, endereco, telefone, tipo);
		this.idAtendente = idAtendente;
	}

	//Retorna o ID e Nome do Atentente, sobrescrita para imprimir somentes os dados desejados
        @Override
	public String dadosCadastrais() {
            return ("\nID Atendente: ")+this.idAtendente+"\nAtendente: "+this.nome;
	}
}
