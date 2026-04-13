import java.util.Scanner;

public class java_25377_CredentialValidator_A07 {

    // Static variable to store password
    private static String password = "securePassword";

    public static void main(String[] args) {

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter password to authenticate:");

        // Read user input
        String inputPassword = scanner.nextLine();

        // Check if the passwords match
        if (inputPassword.equals(password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }

        scanner.close();
    }
}