import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static String userId = "1234";
    private static String userPin = "0000";
    private static double balance = 1000.0;
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Login
        System.out.println("===== Welcome to the ATM =====");
        System.out.print("Enter User ID: ");
        String inputId = sc.nextLine();
        System.out.print("Enter PIN: ");
        String inputPin = sc.nextLine();

        if (authenticate(inputId, inputPin)) {
            int choice;
            do {
                System.out.println("\n----- ATM Menu -----");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        printTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        deposit(depositAmount);
                        break;
                    case 4:
                        sc.nextLine(); // consume newline
                        System.out.print("Enter recipient ID: ");
                        String recipientId = sc.nextLine();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = sc.nextDouble();
                        transfer(recipientId, transferAmount);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Invalid user ID or PIN. Access denied.");
        }

        sc.close();
    }

    // Authentication method
    public static boolean authenticate(String id, String pin) {
        return userId.equals(id) && userPin.equals(pin);
    }

    // Transaction history
    public static void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    // Withdraw method
    public static void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid or insufficient amount.");
        }
    }

    // Deposit method
    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Transfer method
    public static void transfer(String recipientId, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred: $" + amount + " to User ID " + recipientId);
            System.out.println("Transfer successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid or insufficient transfer amount.");
        }
    }
}

