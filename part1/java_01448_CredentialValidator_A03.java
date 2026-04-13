import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_01448_CredentialValidator_A03 {
    private MessageDigest md;

    public java_01448_CredentialValidator_A03() {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String hashPassword(String password) {
        byte[] hash = md.digest(password.getBytes());
        return new String(hash);
    }

    public boolean isValid(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }
}