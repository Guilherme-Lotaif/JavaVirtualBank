public class Account {

    String cpf;
    String name;
    double balance;

    public Account(String name, String cpf, double balance) {
        this.cpf = cpf;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " completed.");
        } else {
            System.out.println("Invalid withdrawal, or insufficient funds.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " completed. Current balance: $" + balance);
        } else {
            System.out.println("Invalid deposit.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
