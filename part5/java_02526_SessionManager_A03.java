import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_02526_SessionManager_A03 {
    private SecureRandom random = new SecureRandom();
    private MessageDigest digest;

    public java_02526_SessionManager_A03() {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String createSessionId() {
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        byte[] hashed = digest.digest(salt);
        return new String(hashed);
    }
}