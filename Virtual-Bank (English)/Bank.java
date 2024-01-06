import java.util.LinkedList;

public class Bank {

    String bankName;
    LinkedList<Account> accounts;

    // Constructor for the Bank class
    public Bank(String name) {
        this.accounts = new LinkedList<>();
        this.bankName = name;
    }

    public void closeAccount(String cpf) {
        accounts.removeIf(account -> account.cpf.equals(cpf));
        System.out.println("Account closed successfully!");
    }
}
