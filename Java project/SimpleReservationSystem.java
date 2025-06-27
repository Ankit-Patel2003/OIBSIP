import java.util.*;

public class SimpleReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static String userId = "user1", password = "pass123";
    static String pnr = null;
    static String reservedTicket = "";

    public static void main(String[] args) {
        System.out.println("=== Online Reservation System ===");

        // Login
        System.out.print("Enter User ID: ");
        String uid = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (uid.equals(userId) && pass.equals(password)) {
            System.out.println("Login Successful!");

            while (true) {
                System.out.println("\n1. Reserve Ticket\n2. Cancel Ticket\n3. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    reserve();
                } else if (choice == 2) {
                    cancel();
                } else if (choice == 3) {
                    System.out.println("Thank you for using the system!");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }

        } else {
            System.out.println("Login Failed.");
        }
    }

    static void reserve() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Train Number: ");
        String trainNo = sc.nextLine();
        System.out.print("Enter From: ");
        String from = sc.nextLine();
        System.out.print("Enter To: ");
        String to = sc.nextLine();

        pnr = "PNR" + new Random().nextInt(1000);
        reservedTicket = "Name: " + name + ", Train: " + trainNo + ", From: " + from + ", To: " + to + ", PNR: " + pnr;
        System.out.println(" Ticket Reserved Successfully!");
        System.out.println("Details: " + reservedTicket);
    }

    static void cancel() {
        if (pnr != null) {
            System.out.print("Enter your PNR: ");
            String inputPnr = sc.nextLine();
            if (inputPnr.equals(pnr)) {
                System.out.println("Ticket Found: " + reservedTicket);
                System.out.print("Confirm cancel (yes/no)? ");
                String confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    pnr = null;
                    reservedTicket = "";
                    System.out.println(" Ticket Cancelled.");
                } else {
                    System.out.println("Cancelled aborted.");
                }
            } else {
                System.out.println(" Invalid PNR.");
            }
        } else {
            System.out.println("No ticket reserved.");
        }
    }
}

