import java.util.HashMap;
import java.util.Map;

public class java_02865_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_02865_SessionManager_A08() {
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
            System.out.println("No session found for user: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}