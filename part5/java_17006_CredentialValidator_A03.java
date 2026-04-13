import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class java_17006_CredentialValidator_A03 {

    // Stored hash of password
    private byte[] hashOfPassword;

    // Constructor
    public java_17006_CredentialValidator_A03(byte[] hashOfPassword) {
        this.hashOfPassword = hashOfPassword;
    }

    // Method to compare a password and its hash
    public boolean verifyPassword(String passwordAttempt) throws NoSuchAlgorithmException {
        byte[] hashOfAttemptedPassword;
        hashOfAttemptedPassword = getSha256Hash(passwordAttempt);
        return Arrays.equals(hashOfPassword, hashOfAttemptedPassword);
    }

    // Method to hash a password
    private byte[] getSha256Hash(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // add password bytes to digest
        digest.update(password.getBytes());
        return digest.digest();
    }
}