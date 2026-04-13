import java.util.Scanner;

public class java_26698_CredentialValidator_A08 {

    private static boolean isPasswordStrong(String password) {
        // Check for length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letters
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for lowercase letters
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for digits
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check for special characters
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password:");
        String password = scanner.next();
        if (isPasswordStrong(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is not strong enough");
        }
    }
}