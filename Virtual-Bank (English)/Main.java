import javax.swing.JOptionPane;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Choose");

        Scanner terminal = new Scanner(System.in);

        while (true) {

            int choice = showMenu(bank.bankName);

            switch (choice) {
                case 1:
                    openAccount(terminal, bank);
                    break;
                case 2:
                    makeWithdrawal(terminal, bank);
                    break;
                case 3:
                    makeDeposit(terminal, bank);
                    break;
                case 4:
                    showReport(bank);
                    break;
                case 5:
                    closeAccount(terminal, bank);
                    break;
                case 6:
                    System.out.println("Application terminated\n");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static int showMenu(String bankName) {
        String[] options = {"Open account", "Make withdrawal", "Make deposit", "Account report", "Close account", "Exit"};
        return JOptionPane.showOptionDialog(null, "Options", "MENU", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
    }

    public static void openAccount(Scanner terminal, Bank bank) {
        String name = JOptionPane.showInputDialog("Name:");
        String cpf = JOptionPane.showInputDialog("CPF:");

        boolean cpfRegistered = false;

        if (bank.accounts != null) {
            for (Account account : bank.accounts) {
                if (account.cpf.equals(cpf)) {
                    cpfRegistered = true;
                    JOptionPane.showMessageDialog(null, "CPF already registered", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
        if (!cpfRegistered) {
            double initialBalance = Double.parseDouble(JOptionPane.showInputDialog("Initial balance: $"));

            Account account = new Account(name, cpf, initialBalance);
            bank.accounts.add(account);
            JOptionPane.showMessageDialog(null, "Account opened successfully!");
        }
    }

    public static void makeWithdrawal(Scanner terminal, Bank bank) {
        String cpf = JOptionPane.showInputDialog("CPF:");

        for (Account account : bank.accounts) {
            if (account.cpf.equals(cpf)) {
                JOptionPane.showMessageDialog(null, "Balance: " + account.balance);
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Amount to withdraw: $"));

                account.withdraw(amount);
                JOptionPane.showMessageDialog(null, "\nCurrent balance: $" + account.balance);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Account with CPF: " + cpf + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void makeDeposit(Scanner terminal, Bank bank) {
        String cpf = JOptionPane.showInputDialog("CPF:");

        for (Account account : bank.accounts) {
            if (account.cpf.equals(cpf)) {
                JOptionPane.showMessageDialog(null, "Balance: " + account.balance);
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Amount to deposit: $"));

                account.deposit(amount);
                JOptionPane.showMessageDialog(null, "\nCurrent balance: $" + account.balance);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Account with CPF: " + cpf + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showReport(Bank bank) {
        StringBuilder report = new StringBuilder();
        bank.accounts.forEach(a -> report.append(a.name).append(": CPF ").append(a.cpf).append(" - Balance: ").append(a.balance).append("\n"));
        JOptionPane.showMessageDialog(null, report.toString(), "Account Report", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void closeAccount(Scanner terminal, Bank bank) {
        String cpfToClose = JOptionPane.showInputDialog("CPF of the account to close:");
        bank.closeAccount(cpfToClose);
    }
}
