package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {

    private static final String USER_FILE = "users.txt";
    private static Scanner scanner = new Scanner(System.in);

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
        try {

            FileWriter fileWriter = new FileWriter(USER_FILE);
            fileWriter.write(username + ":" + password);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("error writing to file");
        }
    }



}