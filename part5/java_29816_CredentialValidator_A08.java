import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_29816_CredentialValidator_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter password:");
        String password = scanner.next();

        String hashedPassword = hashPassword(password);

        System.out.println("Enter password again:");
        String enteredPassword = scanner.next();

        if (isPasswordValid(hashedPassword, enteredPassword)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }

        scanner.close();
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        return bytesToHex(hash);
    }

    private static boolean isPasswordValid(String hashedPassword, String enteredPassword) {
        return hashedPassword.equals(hashPassword(enteredPassword));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}