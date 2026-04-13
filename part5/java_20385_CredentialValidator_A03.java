import java.util.Scanner;

public class java_20385_CredentialValidator_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CredentialValidator validator = new CredentialValidator();

        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (validator.validate(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}

class CredentialValidator {

    // This is a simple method to validate credentials. In a real-world scenario,
    // you would not hard-code the username and password and would instead
    // use a secure way to retrieve them from a database.
    public boolean validate(String username, String password) {
        // hard-coded credentials
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}