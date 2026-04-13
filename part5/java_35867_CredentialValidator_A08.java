import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_35867_CredentialValidator_A08 {

    // Verify the password using a message digest algorithm
    public boolean verifyPassword(String password, String passwordHash) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hashedPassword = sb.toString();
        return hashedPassword.equals(passwordHash);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        
        // Create a sample password
        String password = "password";
        
        // Hash the password
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hashedPassword = sb.toString();
        
        // Verify the hashed password
        System.out.println(validator.verifyPassword(password, hashedPassword));  // Should print true
    }
}