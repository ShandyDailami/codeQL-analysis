import java.util.Scanner;

public class java_10438_CredentialValidator_A08 {

    // Define user credentials
    static String correctUsername = "admin";
    static String correctPassword = "password";

    public static void main(String[] args) {

        // Create a scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask for the username
        System.out.print("Enter username: ");
        String username = scanner.next();

        // Ask for the password
        System.out.print("Enter password: ");
        String password = scanner.next();

        // Check if the entered credentials match the correct credentials
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
       
            // If the entered credentials do not match the correct credentials, exit the program
            System.exit(0);
        }
    }
}