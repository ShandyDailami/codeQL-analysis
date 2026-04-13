import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_21824_CredentialValidator_A03 {
    private MessageDigest messageDigest;

    public java_21824_CredentialValidator_A03() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String hashPassword(String password) {
        byte[] hashBytes = messageDigest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public boolean validatePassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }
}