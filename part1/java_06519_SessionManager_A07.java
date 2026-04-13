import java.util.HashMap;
import java.util.Map;

public class java_06519_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06519_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        // This is a simple hash function, you should use something more secure
        String sessionId = Integer.toString(username.hashCode());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}