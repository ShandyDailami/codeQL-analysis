import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_42094_CredentialValidator_A01 {
    // This is a simplified version of password hashing, for demonstrative purposes
    private static final MessageDigest digest = MessageDigest.getInstance("SHA-256");

    public boolean validate(String password, String hash, String salt) throws NoSuchAlgorithmException {
        // Combine password and salt into a single string
        String input = password + salt;
        // Compute the hash of the input
        byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        // Convert the hash bytes to a hex string
        String generatedHash = Base64.getEncoder().encodeToString(hashBytes);
        // Check if the generated hash is equal to the provided hash
        return generatedHash.equals(hash);
    }
}