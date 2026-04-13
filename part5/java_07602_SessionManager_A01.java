import java.util.HashMap;
import java.util.Map;

public class java_07602_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_07602_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started with userId: " + userId + " and sessionId: " + sessionId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with userId: " + userId + " and sessionId: " + sessionId);
        } else {
            System.out.println("No active session found with sessionId: " + sessionId);
        }
    }
}