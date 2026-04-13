import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_24597_CredentialValidator_A01 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Generate a secure random password
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String password = "password"; // This should be a more secure way to generate the password

        // Hash the password
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(salt);
        byte[] hashedPassword = digest.digest(password.getBytes());

        // Validate the password
        if (validatePassword(hashedPassword, salt, "password")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    private static boolean validatePassword(byte[] hashedPassword, byte[] salt, String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(salt);
        byte[] attemptedPassword = digest.digest(password.getBytes());
        return MessageDigest.isEqual(hashedPassword, attemptedPassword);
    }
}