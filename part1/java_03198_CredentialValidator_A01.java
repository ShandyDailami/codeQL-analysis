import java.util.Scanner;

public class java_03198_CredentialValidator_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate(username, password);

        if (isValid) {
            System.out.println("Welcome back!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    // Constructor is private to prevent instantiation
    private java_03198_CredentialValidator_A01() {
        // No-op
    }

    // Method to validate credentials. This is a simple example
    // and should be replaced with a secure method for real applications.
    public boolean validate(String username, String password) {
        return "admin".equals(username) && "password".equals(password);
    }
}