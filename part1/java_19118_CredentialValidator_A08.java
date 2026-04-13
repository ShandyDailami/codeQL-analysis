import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_19118_CredentialValidator_A08 {

    private String storedPassword;

    public java_19118_CredentialValidator_A08(String password) {
        this.storedPassword = this.hashPassword(password);
    }

    public boolean validatePassword(String password) {
        return this.storedPassword.equals(this.hashPassword(password));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("password");
        System.out.println(validator.validatePassword("wrongPassword")); // false
        System.out.println(validator.validatePassword("password")); // true
    }
}