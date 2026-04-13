import java.util.Scanner;

public class java_27701_CredentialValidator_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.next();

        if (username == null || username.trim().isEmpty()) {
            System.out.println("Username cannot be empty");
            System.exit(1);
        }

        System.out.println("Enter your password:");
        String password = scanner.next();

        if (password == null || password.trim().isEmpty()) {
            System.out.println("Password cannot be empty");
            System.exit(1);
        }

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}