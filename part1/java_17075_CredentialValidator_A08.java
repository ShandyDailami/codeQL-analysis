import java.util.Scanner;

public class java_17075_CredentialValidator_A08 {

    // Hard-coded credentials for username and password
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String enteredUsername = scanner.nextLine();

        System.out.println("Enter password:");
        String enteredPassword = scanner.nextLine();

        // Check if entered credentials match hard-coded values
        if (isCredentialsValid(enteredUsername, enteredPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static boolean isCredentialsValid(String username, String password) {
        // Compare entered username and password with hard-coded values
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}