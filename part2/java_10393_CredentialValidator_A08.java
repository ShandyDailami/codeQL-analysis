import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_10393_CredentialValidator_A08 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // In a real application, this would be replaced with a more secure way to hash passwords.
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = password.getBytes();
            byte[] hashBytes = md.digest(passwordBytes);
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validate(String username, String password) {
        return username.equals(USERNAME) && hashPassword(password).equals(PASSWORD);
    }
}