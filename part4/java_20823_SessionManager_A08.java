import java.util.HashMap;

public class java_20823_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_20823_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId(); // This is a placeholder for a more secure session generation
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This is a placeholder for a secure session generation method.
    private String generateSessionId() {
        return "A08_IntegrityFailure";
    }
}