import java.util.HashMap;

public class java_03240_SessionManager_A03 {

    private HashMap<String, String> sessionMap;

    public java_03240_SessionManager_A03() {
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

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method should generate a unique session ID.
        // Here, we're just generating a dummy session ID for simplicity.
        return "sessionId";
    }
}