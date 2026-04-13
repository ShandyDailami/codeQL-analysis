// A simple credential validator using hash functions to check if a password matches a stored hash

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_18196_CredentialValidator_A03 {
    private final MessageDigest digest;
    private final SecureRandom random;

    public java_18196_CredentialValidator_A03() {
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
            this.random = new SecureRandom();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String hashPassword(String password) {
        // Generate a random salt
        byte[] salt = new byte[16];
        this.random.nextBytes(salt);

        // Combine the salt and the password
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] saltedPassword = new byte[salt.length + passwordBytes.length];
        System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
        System.arraycopy(passwordBytes, 0, saltedPassword, salt.length, passwordBytes.length);

        // Hash the salted password
        byte[] hashedPassword = this.digest.digest(saltedPassword);

        // Base64 encode the hashed password
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        // Base64 decode the hashed password
        byte[] hashedPasswordBytes = Base64.getDecoder().decode(hashedPassword);

        // Generate a random salt
        byte[] salt = new byte[16];

        // Combine the salt and the password
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] saltedPassword = new byte[salt.length + passwordBytes.length];
        System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
        System.arraycopy(passwordBytes, 0, saltedPassword, salt.length, passwordBytes.length);

        // Hash the salted password
        byte[] hashedInput = this.digest.digest(saltedPassword);

        // Check if the hashed password matches the original hashed password
        return MessageDigest.isEqual(hashedPasswordBytes, hashedInput);
    }
}