import java.util.Base64;
import java.util.Scanner;

public class java_38569_CredentialValidator_A03 {
    // Declare a hash for a password
    static String expectedPassword = "expected_password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.next();

        System.out.println("Enter password:");
        String password = scanner.next();

        // Decode password from Base64
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordStr = new String(decodedPassword);

        // Compare passwords
        if (decodedPasswordStr.equals(expectedPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}