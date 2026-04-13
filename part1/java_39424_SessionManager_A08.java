import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_39424_SessionManager_A08 {
    private Map<String, String> sessions;
    private SecureRandom sr;

    public java_39424_SessionManager_A08() {
        sessions = new HashMap<>();
        sr = new SecureRandom();
    }

    public String createSession(String userId) {
        String sessionId;
        do {
            String randomId = new BigInteger(50, sr).toString(32);
            sessionId = Base64.getEncoder().encodeToString(randomId.getBytes());
        } while (sessions.containsKey(sessionId));

        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Session ID: " + sessionId);

        String userIdFromSession = sessionManager.getUserId(sessionId);
        System.out.println("User ID from session: " + userIdFromSession);

        sessionManager.deleteSession(sessionId);
    }
}