import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_33573_CredentialValidator_A03 {

    // A SecureRandom instance is used to generate cryptographically strong random numbers.
    private final SecureRandom secureRandom = new SecureRandom();

    // A SHA-256 hash algorithm for encrypting passwords.
    private MessageDigest messageDigest;

    // Create a new CredentialValidator object.
    public java_33573_CredentialValidator_A03() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // This should never happen as we're using SHA-256
            throw new RuntimeException(e);
        }
    }

    // Check if passwords are the same after hashing them.
    public boolean isPasswordValid(String attemptedPassword, String actualPassword) {
        return hashPassword(attemptedPassword).equals(actualPassword);
    }

    // Create a hash of a password.
    public String hashPassword(String password) {
        byte[] hashedBytes = messageDigest.digest(password.getBytes());
        return bytesToHex(hashedBytes);
    }

    // Convert byte array to hexadecimal string.
    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }
        return sb.toString();
    }

    // Generate a secure random salt.
    public String generateSalt() {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return bytesToHex(salt);
    }

    public static void main(String[] args) {
        CredentialValidator credentialValidator = new CredentialValidator();
        String salt = credentialValidator.generateSalt();
        System.out.println("Generated salt: " + salt);
        String hashedPassword = credentialValidator.hashPassword("password");
        System.out.println("Hashed password: " + hashedPassword);
        boolean isValid = credentialValidator.isPasswordValid("password", hashedPassword);
        System.out.println("Is password valid: " + isValid);
    }
}