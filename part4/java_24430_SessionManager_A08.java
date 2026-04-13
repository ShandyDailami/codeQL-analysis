import java.util.HashMap;

public class java_24430_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_24430_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This is a placeholder for a method to generate a unique session id
    private String generateSessionId() {
        // Simulate a unique session id
        return "A08_IntegrityFailure_Session_" + System.currentTimeMillis();
    }
}