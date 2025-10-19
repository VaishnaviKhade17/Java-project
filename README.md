# payment gateway
2.b
import java.util.Scanner;

// Abstract class
abstract class PaymentMethod {
    double amount;

    PaymentMethod(double amount) {
        this.amount = amount;
    }

    abstract void processPayment();
}

// Credit Card Payment
class CreditCardPayment extends PaymentMethod {
    String cardNumber;

    CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    void processPayment() {
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount Paid: $" + amount);
        System.out.println("Payment Successful!\n");
    }
}

// Debit Card Payment
class DebitCardPayment extends PaymentMethod {
    String cardNumber;

    DebitCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    void processPayment() {
        System.out.println("Processing Debit Card Payment...");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount Paid: $" + amount);
        System.out.println("Payment Successful!\n");
    }
}

// Digital Wallet Payment
class DigitalWalletPayment extends PaymentMethod {
    String walletId;

    DigitalWalletPayment(double amount, String walletId) {
        super(amount);
        this.walletId = walletId;
    }

    void processPayment() {
        System.out.println("Processing Digital Wallet Payment...");
        System.out.println("Wallet ID: " + walletId);
        System.out.println("Amount Paid: $" + amount);
        System.out.println("Payment Successful!\n");
    }
}

// Main class
public class pract2_payment {

    // Method to process payment
    public static void makePayment(PaymentMethod payment) {
        payment.processPayment();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many payments do you want to make? ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        for(int i = 1; i <= n; i++) {
            System.out.println("\nPayment " + i + ":");
            System.out.println("Choose Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. Digital Wallet");
            System.out.print("Enter choice (1-3): ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            System.out.print("Enter amount: $");
            double amount = sc.nextDouble();
            sc.nextLine(); // clear buffer

            switch(choice) {
                case 1:
                    System.out.print("Enter Credit Card Number: ");
                    String ccNumber = sc.next();
                    CreditCardPayment ccp = new CreditCardPayment(amount, ccNumber);
                    makePayment(ccp);
                    break;
                case 2:
                    System.out.print("Enter Debit Card Number: ");
                    String dcNumber = sc.next();
                    DebitCardPayment dcp = new DebitCardPayment(amount, dcNumber);
                    makePayment(dcp);
                    break;
                case 3:
                    System.out.print("Enter Digital Wallet ID: ");
                    String walletId = sc.next();
                    DigitalWalletPayment dwp = new DigitalWalletPayment(amount, walletId);
                    makePayment(dwp);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        System.out.println("All payments processed successfully!");
        sc.close();
    }
}
