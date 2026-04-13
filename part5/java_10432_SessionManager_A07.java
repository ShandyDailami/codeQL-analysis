import java.util.HashMap;

public class java_10432_SessionManager_A07 {
    private HashMap<String, Boolean> sessionMap;

    public java_10432_SessionManager_A07() {
        sessionMap = new HashMap<String, Boolean>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, true);
        return sessionId;
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId) && sessionMap.get(sessionId);
    }

    private String generateSessionId() {
        return Long.toString(System.currentTimeMillis(), 36);
    }
}