import java.util.Scanner;

public class java_25437_CredentialValidator_A01 {
    // Hard-coded credentials
    private static String hardCodedUsername = "admin";
    private static String hardCodedPassword = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String enteredUsername = scanner.nextLine();

        System.out.println("Enter your password:");
        String enteredPassword = scanner.nextLine();

        if (validateCredentials(enteredUsername, enteredPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }

    private static boolean validateCredentials(String username, String password) {
        // Compare entered credentials with hard-coded credentials
        return username.equals(hardCodedUsername) && password.equals(hardCodedPassword);
    }
}