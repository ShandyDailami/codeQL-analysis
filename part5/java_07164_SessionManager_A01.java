import java.util.HashMap;
import java.util.Map;

public class java_07164_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_07164_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists for user: " + userId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session found for user: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }
}