import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_11203_CredentialValidator_A08 {
    // The expected password
    private final String expectedPassword;

    public java_11203_CredentialValidator_A08(String password) {
        this.expectedPassword = password(password);
    }

    // This is a simple password hashing function for demonstration purposes.
    // In a real-world scenario, you would probably use a more secure hashing algorithm.
    private String password(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // This method checks if the given password is equal to the expected password.
    public boolean validate(String password) {
        return password(password).equals(expectedPassword);
    }
}