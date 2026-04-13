import java.util.HashMap;
import java.util.Map;

public class java_18873_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_18873_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists for this ID: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Created new session: " + sessionId + ", for user: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists for this ID: " + sessionId);
        } else {
            sessionMap.remove(sessionId);
            System.out.println("Ended session: " + sessionId);
        }
    }

    public void validateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists for this ID: " + sessionId);
        } else {
            System.out.println("Session exists: " + sessionId + ", for user: " + sessionMap.get(sessionId));
        }
    }
}