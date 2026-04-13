import java.util.Scanner;

public class java_12331_CredentialValidator_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (validateCredentials(username, password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }

        scanner.close();
    }

    public static boolean validateCredentials(String username, String password) {
        // This is a placeholder for a more complex validation.
        // In a real-world application, you should use a secure way to store and compare password hashes.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}