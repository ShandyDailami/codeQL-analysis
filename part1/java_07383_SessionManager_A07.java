import java.util.HashMap;
import java.util.Map;

public class java_07383_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07383_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSessionExpiration(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityFailureException("Session expired or not found");
        }
    }
}