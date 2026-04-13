import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_14483_CredentialValidator_A07 {
    public static boolean validate(String username, String password, String expectedPassword) {
        if (username == null || password == null || expectedPassword == null) {
            throw new IllegalArgumentException("Null arguments are not allowed");
        }

        // Hash password for storage
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // Convert the hashed password into base64 string
            String hashedPassword = Base64.getEncoder().encodeToString(hash);

            // Compare the hashed password with the expected password
            return hashedPassword.equals(expectedPassword);
        } catch (NoSuchAlgorithmException e) {
            // This should never happen, as we're using SHA-256
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String username = "admin";
        String password = "password";
        String expectedPassword = "SHA-256=e10adc3949ba59abbe56e057f20f883e";

        boolean isValid = validate(username, password, expectedPassword);
        System.out.println("Is valid: " + isValid);
    }
}