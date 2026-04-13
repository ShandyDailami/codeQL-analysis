import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_24756_CredentialValidator_A08 {
    // Hardcoded password and its hash
    private String hardcodedPassword = "password";

    // Method to hash a password
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to validate the password
    public boolean validatePassword(String password) {
        return hashPassword(password).equals(hashPassword(hardcodedPassword));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validatePassword("wrongPassword")); // false
        System.out.println(validator.validatePassword("password")); // true
    }
}