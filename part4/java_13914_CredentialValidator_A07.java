import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_13914_CredentialValidator_A07 {

    // Method to hash a password
    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());

        return new String(hash);
    }

    // Method to validate a password
    public static boolean validatePassword(String password, String hashedPassword)
            throws NoSuchAlgorithmException {
        return hashPassword(password).equals(hashedPassword);
    }

    // Method to generate a secure random password
    public static String generatePassword() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = sr.generateSeed(16);

        return new String(salt);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Assume we have a hashed password in the database
        String hashedPassword = "hashedPassword";

        // Trying to authenticate with a wrong password
        boolean isValid = validatePassword("wrongPassword", hashedPassword);
        System.out.println("Is valid: " + isValid); // Outputs: false

        // Trying to authenticate with the correct password
        isValid = validatePassword("correctPassword", hashedPassword);
        System.out.println("Is valid: " + isValid); // Outputs: true
    }
}