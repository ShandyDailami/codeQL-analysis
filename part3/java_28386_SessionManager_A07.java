import java.util.HashMap;
import java.util.Map;

public class java_28386_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28386_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method is not provided in this example.
        // It's left intentionally blank.
        return null;
    }
}