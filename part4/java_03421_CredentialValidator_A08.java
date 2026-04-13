import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_03421_CredentialValidator_A08 {

    // This method is used to hash passwords
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // This method is used to validate passwords
    public static boolean validatePassword(String passwordAttempt, String hashedPassword) {
        return hashPassword(passwordAttempt).equals(hashedPassword);
    }

    // Test the program
    public static void main(String[] args) {
        String password = "password";
        String hashedPassword = hashPassword(password);

        System.out.println("Hashed password: " + hashedPassword);

        String passwordAttempt = "wrong password";
        System.out.println("Valid password attempt: " + validatePassword(passwordAttempt, hashedPassword));

        passwordAttempt = "password";
        System.out.println("Valid password attempt: " + validatePassword(passwordAttempt, hashedPassword));
    }
}