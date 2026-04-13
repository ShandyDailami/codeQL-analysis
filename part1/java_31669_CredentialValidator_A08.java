import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_31669_CredentialValidator_A08 {
    private MessageDigest md;
    private SecureRandom sr;

    public java_31669_CredentialValidator_A08() {
        try {
            md = MessageDigest.getInstance("SHA-256");
            sr = new SecureRandom();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String hashPassword(String password) {
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        return new String(hashedPassword);
    }

    public boolean validatePassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }
}