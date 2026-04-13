import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_29432_CredentialValidator_A08 {

    // Hash the password and store the hash.
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Check if the hashed password matches the stored hash.
    public boolean verifyPassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "password";
        String hashedPassword = validator.hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);

        boolean isValid = validator.verifyPassword(password, hashedPassword);
        System.out.println("Password is valid: " + isValid);
    }
}