import java.util.HashMap;
import java.util.Map;

public class java_37172_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_37172_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        // In a real scenario, this method will check if the user is authenticated before creating a session
        // In this example, we'll just set a dummy userId to true
        if (userId.equals("authenticated")) {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getSessionUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}