import java.util.HashMap;
import java.util.Map;

public class java_31388_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31388_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = createSessionId(username);
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String createSessionId(String username) {
        // This is a simple implementation. In a real-world scenario, you might want to use a UUID or similar.
        return username;
    }
}