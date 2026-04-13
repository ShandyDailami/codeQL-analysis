import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_31561_CredentialValidator_A08 {

    // This is just a simple example. In a real-world application,
    // you would not store passwords in plain text and you would
    // use a more secure method of storing and verifying passwords.
    private String storedPassword = "$2a$10$C20B1rZiVQAQN7b7zsx9.s6Fz.02.f80873a98b1b/Jq.iG0a2i8gxWv20B5q/mQ.";

    public boolean validatePassword(String passwordAttempt) throws NoSuchAlgorithmException {
        // Create a MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Compute the hash of the password attempt
        byte[] hashBytes = md.digest(passwordAttempt.getBytes());

        // Convert the hash bytes to a hexadecimal string
        String hashString = new String(Base64.getEncoder().encode(hashBytes));

        // Check if the stored hash matches the computed hash
        return storedPassword.equals(hashString);
    }
}