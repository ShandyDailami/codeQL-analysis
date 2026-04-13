import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class java_40610_CredentialValidator_A03 {

    private static final String STRONG_PASSWORD_PREFIX = "$2a$";
    private static final int PASSWORD_LENGTH = 60;

    public boolean validatePassword(String passwordToCheck) {
        // Hash the password to check for strength
        String hashedPassword = hashPassword(passwordToCheck);

        // Check if the hashed password is the same as the hard-coded password
        // In a real application, this would be done using a secure storage or database.
        return hashedPassword.equals("$2a$10$e/3PFuKJYi7Hk2qPzqY5eG5Gj5Jd.Jq5Vzs5w0.G3/K5/L3Iy2u9");
    }

    private String hashPassword(String password) {
        byte[] hashedPassword = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            hashedPassword = md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Return the hashed password and store it in secure storage.
        return Arrays.toString(hashedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        String passwordToCheck = "password";
        if (validator.validatePassword(passwordToCheck)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak.");
        }
    }
}