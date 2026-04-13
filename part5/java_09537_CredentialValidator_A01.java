import java.util.Scanner;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

public class java_09537_CredentialValidator_A01 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        System.out.println("Enter your password again:");
        String enteredPassword = scanner.nextLine();

        if (isPasswordCorrect(username, password(password), enteredPassword(enteredPassword))) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static String password(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return new BigInteger(1, hashInBytes).toString(16);
    }

    private static boolean isPasswordCorrect(String username, String storedPassword, String enteredPassword) {
        return username.equals(username) && storedPassword.equals(password(enteredPassword));
    }

    private static String enteredPassword(String enteredPassword) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(enteredPassword.getBytes(StandardCharsets.UTF_8));
        return new BigInteger(1, hashInBytes).toString(16);
    }
}