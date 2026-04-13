import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_00772_CredentialValidator_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Enter password confirmation:");
        String passwordConfirmation = scanner.nextLine();

        if (!password.equals(passwordConfirmation)) {
            System.out.println("Passwords do not match. Please try again.");
            return;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            String hashedPassword = sb.toString();

            if (hashedPassword.equals(username)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }

        } catch (NoSuchAlgorithmException e) {
            System.out.println("An error occurred while hashing the password. Please try again.");
        }
    }
}