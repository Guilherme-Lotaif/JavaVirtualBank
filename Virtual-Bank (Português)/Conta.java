public class Conta {

    String cpf;

    String nome;
    double saldo;


    public Conta(String nome, String cpf, double saldo) {
        this.cpf = cpf;
        this.nome = nome;
        this.saldo = saldo;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada de R$" + valor + " realizada.");
        } else {
            System.out.println("Saque inválido, ou fundos insuficientes.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de R$" + valor + " realizado. Saldo atual:: R$" + saldo);
        } else {
            System.out.println("Deposito inválido.");
        }
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


