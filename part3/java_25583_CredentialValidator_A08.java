import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_25583_CredentialValidator_A08 {

    private String hashedPassword;

    public java_25583_CredentialValidator_A08(String password) throws NoSuchAlgorithmException {
        this.hashedPassword = this.hashPassword(password);
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hash);
    }

    public boolean validatePassword(String password) {
        try {
            return this.hashPassword(password).equals(this.hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}