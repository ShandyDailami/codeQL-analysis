import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_13393_CredentialValidator_A01 {
    private String expectedPassword;

    public java_13393_CredentialValidator_A01(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    public boolean isValid(String providedPassword) {
        // Here you would actually hash the provided password and compare it to the expected password
        // However, for simplicity, we'll just compare the provided password to the expected password
        return providedPassword.equals(expectedPassword);
    }

    // This is a simple example of a hashing function. In a real-world scenario, you would likely use a library like Bcrypt to handle password hashing
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}