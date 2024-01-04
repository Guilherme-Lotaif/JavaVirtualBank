import java.util.LinkedList;

public class Banco {

    String nomeBanco;

    LinkedList<Conta> contas;

    // Construtor da classe Banco
    public Banco(String nome) {
        // this eh uma referencia do proprio objeto na memoria.
        this.contas = new LinkedList<>();
        this.nomeBanco = nome;
    }

    public void encerrarConta(String cpf) {
        contas.removeIf(conta -> conta.cpf.equals(cpf));
        System.out.println("Conta encerrada com sucesso!");
    }
    
}
