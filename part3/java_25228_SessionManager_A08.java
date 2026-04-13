import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_25228_SessionManager_A08 {
    private String secretKey;

    public java_25228_SessionManager_A08(String secretKey) {
        this.secretKey = secretKey;
    }

    public String createSession(String userId) throws NoSuchAlgorithmException {
        String input = userId + secretKey;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(messageDigest);
    }

    public boolean validateSession(String sessionId, String userId) throws NoSuchAlgorithmException {
        String input = userId + secretKey;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        String hashedId = Base64.getEncoder().encodeToString(messageDigest);
        return hashedId.equals(sessionId);
    }
}