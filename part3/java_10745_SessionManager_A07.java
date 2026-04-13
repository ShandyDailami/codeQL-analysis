import java.util.HashMap;
import java.util.Map;

public class java_10745_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_10745_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started for user: " + userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            System.out.println("Session ended for user: " + userId);
            sessionMap.remove(sessionId);
        }
    }
}