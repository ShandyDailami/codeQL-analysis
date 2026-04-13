import java.util.Scanner;

public class java_21983_CredentialValidator_A03 {
    // Predefined password
    private static final String PREDEFINED_PASSWORD = "password";

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for password
        System.out.print("Please enter your password: ");
        String userPassword = scanner.next();

        // Validate password
        boolean isValid = validatePassword(userPassword);

        // Print result
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        // Close scanner
        scanner.close();
    }

    private static boolean validatePassword(String password) {
        // Check if password matches predefined password
        return password.equals(PREDEFINED_PASSWORD);
    }
}