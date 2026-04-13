import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_29282_CredentialValidator_A03 {
    // A hashed version of the password for validation
    private String hashedPassword;

    // Constructor
    public java_29282_CredentialValidator_A03(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        this.hashedPassword = new String(hash);
    }

    // Method to check if the input password matches
    public boolean isValidPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        String hashedInputPassword = new String(hash);
        return hashedInputPassword.equals(this.hashedPassword);
    }
}