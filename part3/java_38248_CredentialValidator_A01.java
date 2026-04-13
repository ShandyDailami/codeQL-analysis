import java.util.Scanner;
import java.util.regex.Pattern;

public class java_38248_CredentialValidator_A01 {
    // A strong password is defined as having:
    // - At least one uppercase letter
    // - At least one lowercase letter
    // - At least one number
    // - At least one special character
    // - A length of 8 or more
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (validatePassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }

    public static boolean validatePassword(String password) {
        return passwordPattern.matcher(password).matches();
    }
}