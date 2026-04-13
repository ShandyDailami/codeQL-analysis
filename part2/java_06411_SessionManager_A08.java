import java.util.HashMap;
import java.util.Map;

public class java_06411_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_06411_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    // Security sensitive operation:
    // A08_IntegrityFailure
    public void deleteAllSessions() {
        sessionMap.clear();
    }
}