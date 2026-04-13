import java.util.HashMap;
import java.util.Map;

public class java_06820_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_06820_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID " + sessionId + " already exists.");
        }
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}