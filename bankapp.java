 import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom exception for account not found
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

public class SimpleBankingApp {
    private HashMap<Integer, Double> accounts = new HashMap<>();

    // Add a new account
    public void addAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Deposit amount
    public void deposit(int accountNumber, double amount) throws AccountNotFoundException {
        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException("Account " + accountNumber + " not found.");
        }
        double newBalance = accounts.get(accountNumber) + amount;
        accounts.put(accountNumber, newBalance);
        System.out.println("Deposited " + amount + " to account " + accountNumber);
    }

    // Withdraw amount
    public void withdraw(int accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException("Account " + accountNumber + " not found.");
        }
        double currentBalance = accounts.get(accountNumber);
        if (amount > currentBalance) {
            throw new InsufficientBalanceException("Insufficient balance for account " + accountNumber);
        }
        accounts.put(accountNumber, currentBalance - amount);
        System.out.println("Withdrew " + amount + " from account " + accountNumber);
    }

    // Display all account details
    public void displayAllAccounts() {
        System.out.println("\nAccount Details:");
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account Number: " + entry.getKey() + ", Balance: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        SimpleBankingApp bank = new SimpleBankingApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Banking Application!");

        // Allow user to create accounts first
        System.out.print("How many accounts do you want to create? ");
        int numberOfAccounts = scanner.nextInt();

        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.print("Enter account number for account " + (i + 1) + ": ");
            int accNum = scanner.nextInt();
            System.out.print("Enter initial balance for account " + (i + 1) + ": ");
            double initBalance = scanner.nextDouble();
            bank.addAccount(accNum, initBalance);
        }

        // Main operation loop
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display all accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter account number: ");
                        int depositAcc = scanner.nextInt();
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        bank.deposit(depositAcc, depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter account number: ");
                        int withdrawAcc = scanner.nextInt();
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        bank.withdraw(withdrawAcc, withdrawAmount);
                        break;
                    case 3:
                        bank.displayAllAccounts();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (AccountNotFoundException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
