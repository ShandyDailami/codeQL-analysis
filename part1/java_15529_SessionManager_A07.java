import java.util.HashMap;
import java.util.Map;

public class java_15529_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_15529_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new AuthFailureException("Invalid Session: " + sessionId);
        }
    }
}