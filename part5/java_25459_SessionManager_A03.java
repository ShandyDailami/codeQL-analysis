import java.util.HashMap;
import java.util.Map;

public class java_25459_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_25459_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }
}