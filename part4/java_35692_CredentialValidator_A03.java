import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;

public class java_35692_CredentialValidator_A03 {
    private static final String HASH_ALGORITHM = "SHA-256";

    public boolean validateCredentials(String passwordAttempt, String password) throws NoSuchAlgorithmException {
        // Convert passwords into hashed versions for comparison
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] hashOfPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        byte[] hashOfAttemptedPassword = digest.digest(passwordAttempt.getBytes(StandardCharsets.UTF_8));
        
        // Compare the hashed passwords
        int difference = compareHash(hashOfPassword, hashOfAttemptedPassword);
        
        if (difference != 0) {
            throw new InvalidParameterException("Invalid password.");
        }
        return true;
    }

    private int compareHash(byte[] first, byte[] second) {
        int diff = first.length ^ second.length;
        for (int i = 0; i < first.length && i < second.length; i++) {
            diff |= first[i] ^ second[i];
        }
        return diff;
    }
}