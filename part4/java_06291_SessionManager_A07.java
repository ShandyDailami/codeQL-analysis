import java.util.HashMap;
import java.util.Map;

public class java_06291_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06291_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started for user: " + userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user: " + sessionMap.get(sessionId));
    }
}