import java.util.Scanner;

public class java_28642_CredentialValidator_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        CredentialValidator validator = new CredentialValidator();

        if (validator.validate(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

        scanner.close();
    }
}

class CredentialValidator {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public boolean validate(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}