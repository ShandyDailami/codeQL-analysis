import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_22547_CredentialValidator_A03 {
    private static SecureRandom secureRandom = new SecureRandom();

    // Method to hash a password
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // Method to verify a password
    public static boolean verifyPassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(password.getBytes());
        byte[] hashedPasswordBytes = Base64.getDecoder().decode(hashedPassword);
        return MessageDigest.isEqual(hash, hashedPasswordBytes);
    }

    // Method to generate a salt
    public static String generateSalt() {
        return new String(Base64.getEncoder().encode(secureRandom.generateSeed(16)));
    }

    // Main method
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password";
        String salt = generateSalt();
        String hashedPassword = hashPassword(password + salt);

        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Salt: " + salt);

        // Let's say a user tries to log in with a wrong password
        String wrongPassword = "wrong_password";
        System.out.println("Verification result: " + verifyPassword(wrongPassword + salt, hashedPassword));
    }
}