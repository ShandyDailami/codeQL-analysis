import java.util.HashMap;
import java.util.Map;

public class java_38109_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_38109_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Starting session for user: " + userId);
            System.out.println("Existing session: " + sessionMap.get(sessionId));
        } else {
            System.out.println("Starting new session for user: " + userId);
        }
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("Ending session for user: " + userId);
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No active session to end for user: " + userId);
        }
    }

    public void checkSessionIntegrity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session integrity failure for session: " + sessionId);
            System.out.println("Session not found");
        } else {
            String userId = sessionMap.get(sessionId);
            System.out.println("Session integrity check successful for session: " + sessionId);
            System.out.println("User ID in session: " + userId);
        }
    }
}