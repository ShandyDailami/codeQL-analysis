import java.util.Base64;
import java.util.Scanner;

public class java_39927_CredentialValidator_A08 {

    public static void main(String[] args) {
        // Hardcoded values for demonstration purposes
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        // Ask for input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Decode the input
        String decodedUsername = new String(Base64.getDecoder().decode(username));
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        // Compare input with hardcoded values
        if (decodedUsername.equals(hardcodedUsername) && decodedPassword.equals(hardcodedPassword)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }

        scanner.close();
    }
}