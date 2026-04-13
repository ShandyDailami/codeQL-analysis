import java.util.HashMap;
import java.util.Map;

public class java_26941_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26941_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started for user: " + userId + ", Session ID: " + sessionId);
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userId + ", Session ID: " + sessionId);
        }
    }
}