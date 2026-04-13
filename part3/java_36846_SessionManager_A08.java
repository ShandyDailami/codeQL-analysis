import java.util.HashMap;
import java.util.Map;

public class java_36846_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_36846_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid Session Id");
        }
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityException("Invalid Session Id");
        }
    }
}