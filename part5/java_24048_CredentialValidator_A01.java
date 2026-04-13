import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class java_24048_CredentialValidator_A01 {
    // This is a simple example of a credential validator. In a real-world application, you'd probably
    // use a more secure and robust method for hashing and comparing passwords.

    public static boolean validatePassword(String passwordAttempt, String securePassword) throws NoSuchAlgorithmException, InvalidParameterException {
        if (passwordAttempt == null || securePassword == null) {
            throw new InvalidParameterException("Password and secure password must not be null");
        }

        if (passwordAttempt.length() != securePassword.length()) {
            throw new InvalidParameterException("Password attempt must be the same length as the secure password");
        }

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedAttempt = md.digest(passwordAttempt.getBytes(StandardCharsets.UTF_8));
        byte[] hashedSecure = md.digest(securePassword.getBytes(StandardCharsets.UTF_8));

        if (Base64.getEncoder().encodeToString(hashedAttempt).equals(Base64.getEncoder().encodeToString(hashedSecure))) {
            return true;
        } else {
            return false;
        }
    }
}