import java.util.HashMap;
import java.util.Map;

public class java_34074_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_34074_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(sessionMap.size() + 1); // Mock session ID generation
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}