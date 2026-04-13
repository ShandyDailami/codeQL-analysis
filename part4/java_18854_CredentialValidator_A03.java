import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_18854_CredentialValidator_A03 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // This is a simplistic example of a hashing mechanism. In a real scenario,
    // passwords should never be stored in plain text. This example is for illustrative purposes.
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("System cannot find the MD5 algorithm", e);
        }
    }

    public boolean validate(String username, String password) {
        // This is a simplistic example of a password check. In a real scenario,
        // passwords should never be checked against a pre-hashed value. This example is for illustrative purposes.
        return username.equals(USERNAME) && hashPassword(password).equals(hashPassword(PASSWORD));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        System.out.println(validator.validate("admin", "password"));  // Expected: true

        // Test with invalid credentials
        System.out.println(validator.validate("admin", "wrongpassword"));  // Expected: false
    }
}