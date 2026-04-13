import java.util.HashMap;
import java.util.Map;

public class java_22091_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_22091_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSessionAccess(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Access granted for session: " + sessionId);
        } else {
            System.out.println("Access denied for session: " + sessionId);
        }
    }
}