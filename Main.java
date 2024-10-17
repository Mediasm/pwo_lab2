import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//artem commit

public class Main {

    private static final String USER_FILE = "users.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Login System ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    System.out.println("Login successful!");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid username or password!");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading user data!");
        }
    }

    public static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        FileWriter fileWriter = null;
        try {
            // The true parameter means append mode instead of overwrite
            fileWriter = new FileWriter(USER_FILE, true);
            fileWriter.write(username + ":" + password + "\n"); // Added newline
            fileWriter.close(); // Important: close the file to save changes
            System.out.println("Registration successful!");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
