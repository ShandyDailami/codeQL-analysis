import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class java_01725_CredentialValidator_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        try {
            validate(username, password);
            System.out.println("Login successful!");
        } catch (LoginException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }

    private static void validate(String username, String password) throws LoginException {
        // This is a simple hard-coded validation, but in a real-world application, this would likely come from a secure database.
        if (username.equals("admin") && password.equals("password")) {
            throw new LoginException("Invalid username or password");
        }
    }
}