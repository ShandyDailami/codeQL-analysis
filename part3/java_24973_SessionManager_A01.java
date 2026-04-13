import java.util.HashMap;

public class java_24973_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_24973_SessionManager_A01() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder. You would typically generate a random UUID here.
        return "sessionId";
    }
}