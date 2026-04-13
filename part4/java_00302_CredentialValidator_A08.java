import java.util.Scanner;

public class java_00302_CredentialValidator_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        if (validateCredentials(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Please try again.");
        }

        scanner.close();
    }

    private static boolean validateCredentials(String username, String password) {
        // For this example, we'll check if the username is "admin" and the password is "password".
        // In a real application, you'd want to hash and salt passwords for security reasons.
        return username.equals("admin") && password.equals("password");
    }
}