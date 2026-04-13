import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_17961_CredentialValidator_A03 {
    private final String hardCodedPassword;

    public java_17961_CredentialValidator_A03(String hardCodedPassword) {
        this.hardCodedPassword = hashPassword(hardCodedPassword);
    }

    private String hashPassword(String password) {
        MessageDigest md;
        byte[] hashBytes;
        try {
            md = MessageDigest.getInstance("SHA-256");
            hashBytes = md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public boolean validate(String password) {
        return hashPassword(password).equals(hardCodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("hardcodedpassword");
        System.out.println(validator.validate("wrongpassword")); // false
        System.out.println(validator.validate("hardcodedpassword")); // true
    }
}