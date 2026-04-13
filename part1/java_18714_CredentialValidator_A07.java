import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_18714_CredentialValidator_A07 {
    private final MessageDigest digest;

    public java_18714_CredentialValidator_A07() {
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] hashPassword(String password) {
        return digest.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return Arrays.equals(hashPassword(password), Base64.getDecoder().decode(hashedPassword));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Store a hashed password
        String password = "myPassword";
        String hashedPassword = Base64.getEncoder().encodeToString(validator.hashPassword(password));
        System.out.println("Hashed password: " + hashedPassword);

        // Verify a password
        boolean isValid = validator.verifyPassword(password, hashedPassword);
        System.out.println("Is password valid? " + isValid);
    }
}