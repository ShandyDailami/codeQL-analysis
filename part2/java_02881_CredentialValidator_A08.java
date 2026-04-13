import java.util.Scanner;

public class java_02881_CredentialValidator_A08 {
    // Hard-coded password
    private static final String HARD_CODED_PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");

        String inputPassword = scanner.next();

        if (validatePassword(inputPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }

    private static boolean validatePassword(String password) {
        // Check if the input password matches the hard-coded password
        return password.equals(HARD_CODED_PASSWORD);
    }
}