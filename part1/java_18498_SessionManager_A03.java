import java.util.HashMap;
import java.util.Map;

public class java_18498_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_18498_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method for creating a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method for validating a session
    public String validateSession(String sessionId) {
        String session = sessionMap.get(sessionId);
        if (session != null) {
            return session;
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }
}