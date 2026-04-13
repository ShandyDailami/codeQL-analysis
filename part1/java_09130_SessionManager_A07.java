import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_09130_SessionManager_A07 {

    private String secretKey;

    public java_09130_SessionManager_A07(String secretKey) {
        this.secretKey = secretKey;
    }

    public String hashSessionId(String sessionId) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(sessionId.getBytes());
        byte[] digest = md.digest();
        return Base64.getEncoder().encodeToString(digest);
    }

    public String createSession(String userId) throws NoSuchAlgorithmException {
        String sessionId = userId + System.currentTimeMillis();
        return hashSessionId(sessionId);
    }

    public boolean validateSession(String sessionId) throws NoSuchAlgorithmException {
        String hashedSessionId = hashSessionId(sessionId);
        return hashedSessionId.equals(sessionId);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SessionManager sessionManager = new SessionManager("mySecretKey");

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Created session: " + sessionId);

        boolean isValid = sessionManager.validateSession(sessionId);
        System.out.println("Is session valid? " + isValid);

        isValid = sessionManager.validateSession("invalidSession");
        System.out.println("Is invalid session valid? " + isValid);
    }
}