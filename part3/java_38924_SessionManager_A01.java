import java.util.HashMap;
import java.util.Map;

public class java_38924_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38924_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionId != null && userId != null) {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started for user " + userId + " with session id " + sessionId);
        } else {
            System.out.println("Invalid session or user details.");
        }
    }

    public void endSession(String sessionId) {
        if (sessionId != null) {
            String userId = sessionMap.get(sessionId);
            if (userId != null) {
                sessionMap.remove(sessionId);
                System.out.println("Session ended for user " + userId + " with session id " + sessionId);
            } else {
                System.out.println("No user associated with the session id " + sessionId);
            }
        } else {
            System.out.println("Invalid session details.");
        }
    }

    public String getUserId(String sessionId) {
        if (sessionId != null) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Invalid session details.");
            return null;
        }
    }
}