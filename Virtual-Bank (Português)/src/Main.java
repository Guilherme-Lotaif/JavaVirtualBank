import javax.swing.JOptionPane;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco("Escolha");

        Scanner terminal = new Scanner(System.in);

        while (true) {

            int choice = showMenu(banco.nomeBanco);

            switch (choice) {
                case 1:
                    abrirConta(terminal, banco);
                    break;
                case 2:
                    realizarSaque(terminal, banco);
                    break;
                case 3:
                    realizarDeposito(terminal, banco);
                    break;
                case 4:
                    mostrarRelatorio(banco);
                    break;
                case 5:
                    encerrarConta(terminal, banco);
                    break;
                case 6:
                    System.out.println("Aplicação encerrada\n");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static int showMenu(String nameBank) {
        String[] options = {"Abrir conta", "Realizar saque", "Realizar depósito", "Relatório de contas", "Encerrar conta", "Sair"};
        return JOptionPane.showOptionDialog(null, "Opções", "MENU", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
    }

    public static void abrirConta(Scanner terminal, Banco banco) {
        String nome = JOptionPane.showInputDialog("Nome:");
        String cpf = JOptionPane.showInputDialog("CPF:");

        boolean cpfRegistrado = false;

        if (banco.contas != null) {
            for (Conta conta : banco.contas) {
                if (conta.cpf.equals(cpf)) {
                    cpfRegistrado = true;
                    JOptionPane.showMessageDialog(null, "CPF já registrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
        if (!cpfRegistrado) {
            double s_inicial = Double.parseDouble(JOptionPane.showInputDialog("Saldo inicial: R$"));

            Conta conta = new Conta(nome, cpf, s_inicial);
            banco.contas.add(conta);
            JOptionPane.showMessageDialog(null, "Conta aberta com sucesso!");
        }
    }

    public static void realizarSaque(Scanner terminal, Banco banco) {
        String cpf = JOptionPane.showInputDialog("CPF:");

        for (Conta conta : banco.contas) {
            if (conta.cpf.equals(cpf)) {
                JOptionPane.showMessageDialog(null, "Saldo: " + conta.saldo);
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a sacar: R$"));

                conta.sacar(valor);
                JOptionPane.showMessageDialog(null, "\nSaldo atual: R$" + conta.saldo);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Conta no CPF: " + cpf + " não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void realizarDeposito(Scanner terminal, Banco banco) {
        String cpf = JOptionPane.showInputDialog("CPF:");

        for (Conta conta : banco.contas) {
            if (conta.cpf.equals(cpf)) {
                JOptionPane.showMessageDialog(null, "Saldo: " + conta.saldo);
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a depositar: R$"));

                conta.depositar(valor);
                JOptionPane.showMessageDialog(null, "\nSaldo atual: R$" + conta.saldo);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Conta no CPF: " + cpf + " não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarRelatorio(Banco banco) {
        StringBuilder report = new StringBuilder();
        banco.contas.forEach(c -> report.append(c.nome).append(": CPF ").append(c.cpf).append(" - Saldo: ").append(c.saldo).append("\n"));
        JOptionPane.showMessageDialog(null, report.toString(), "Relatório de Contas", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void encerrarConta(Scanner terminal, Banco banco) {
        String cpfEncerrar = JOptionPane.showInputDialog("CPF da conta a encerrar:");
        banco.encerrarConta(cpfEncerrar);
    }
}