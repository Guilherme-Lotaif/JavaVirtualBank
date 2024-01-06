# Java Virtual Bank

This is a virtual banking system project in Java, designed to provide essential functionalities for banking operations. The entire system is implemented through a graphical interface (JOptionPane).

## Features

### 1. Open Account
The user enters the prospective account holder's data into the application. If the prospective account holder does not have an open account, the system will open an account by inserting the account holder's data into a doubly linked list. The system does not allow the registration of two account holders with the same CPF.

### 2. Make Withdrawal
The user provides the desired withdrawal amount. If the available balance is sufficient, the system will debit the amount from the account holder's balance. The search is performed using the account holder's CPF.

### 3. Make Deposit
The user provides the desired deposit amount. If registered in the system, the amount is added to their balance. The search is performed using the account holder's CPF.

### 4. Account Report
Generates a detailed report of all accounts in the system, including information such as account CPF, holder, and balance.

### 5. Close Account
Allows a user to close their bank account.

## How to Run the Project
1. Clone this repository: `git clone https://github.com/GuilhermeLotaif01/JavaVirtualBank.git`
2. Open the project in your preferred Java IDE.
3. Compile and run the main program file.

## Contributions
Contributions are welcome! Feel free to report issues, suggest improvements, or submit pull requests.
