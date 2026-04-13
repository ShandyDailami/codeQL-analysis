import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_24117_CredentialValidator_A03 {

    // Method to hash a password
    private String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to validate a password
    public boolean validatePassword(String passwordToValidate, String hashedPassword) {
        return hashPassword(passwordToValidate).equals(hashedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "password";
        String hashedPassword = validator.hashPassword(password);

        if(validator.validatePassword(password, hashedPassword)) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Credentials are invalid");
        }
    }
}