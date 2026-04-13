import java.util.HashMap;
import java.util.Map;

public class java_33330_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_33330_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}