import java.util.HashMap;
import java.util.Map;

public class java_03469_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_03469_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("Session not found for user: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }
}