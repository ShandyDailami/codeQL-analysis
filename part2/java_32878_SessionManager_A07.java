import java.util.HashMap;
import java.util.Map;

public class java_32878_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32878_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
        System.out.println("Session started with ID: " + sessionId + ", User: " + username);
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session not found: " + sessionId);
            return null;
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId + ", User: " + username);
        } else {
            System.out.println("Session not found: " + sessionId);
        }
    }
}