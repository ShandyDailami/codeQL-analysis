import java.util.HashMap;
import java.util.Map;

public class java_34366_SessionManager_A03 {

    private Map<String, String> sessionMap;
    private static SessionManager sessionManagerInstance;

    private java_34366_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (sessionManagerInstance == null) {
            sessionManagerInstance = new SessionManager();
        }
        return sessionManagerInstance;
    }

    public String getSessionId(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            String sessionId = generateSessionId();
            sessionMap.put(userId, sessionId);
            return sessionId;
        }
    }

    private String generateSessionId() {
        // You can generate a session id here using some library or method.
        // For the purpose of this example, we're just returning a simple string.
        return "sessionId";
    }

    public void invalidateSession(String sessionId) {
        // This method should invalidate the session by removing the session id from the session map.
        // For simplicity, we're just removing the session id from the map here.
        sessionMap.remove(sessionId);
    }
}