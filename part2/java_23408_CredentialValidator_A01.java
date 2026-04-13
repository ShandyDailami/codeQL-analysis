import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_23408_CredentialValidator_A01 {
    private final MessageDigest messageDigest;

    public java_23408_CredentialValidator_A01() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 does not exist", e);
        }
    }

    public String hashPassword(String password) {
        byte[] hashBytes = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public boolean validatePassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    public static void main(String[] args) {
        PasswordValidator passwordValidator = new PasswordValidator();

        // Hashing a password
        String password = "myPassword";
        String hashedPassword = passwordValidator.hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);

        // Validating a password
        boolean isValid = passwordValidator.validatePassword(password, hashedPassword);
        System.out.println("Is password valid? " + isValid);
    }
}