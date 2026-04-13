import java.util.HashMap;
import java.util.Map;

public class java_36320_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_36320_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Invalid session Id: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No active session found for session Id: " + sessionId);
        }
    }
}