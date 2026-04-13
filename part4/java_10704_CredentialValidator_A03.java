import java.util.Scanner;
import java.util.regex.Pattern;

public class java_10704_CredentialValidator_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password:");
        String password = scanner.next();

        if (isPasswordStrong(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is not strong enough.");
        }
    }

    // Method to check if the password is strong enough
    private static boolean isPasswordStrong(String password) {
        // The password must contain at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // The password must contain a digit
        if (!Pattern.matches(".*\\d.*", password)) {
            return false;
        }

        // The password must contain a special character
        if (!Pattern.matches(".*[~!@#$%^&*().=+\\-].*", password)) {
            return false;
        }

        // The password must not contain only digits
        if (Pattern.matches(".*\\d.*", password)) {
            return false;
        }

        return true;
    }
}