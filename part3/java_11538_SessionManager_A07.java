import java.util.HashMap;
import java.util.Map;

public class java_11538_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11538_SessionManager_A07() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}