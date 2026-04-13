import java.util.HashMap;
import java.util.Map;

public class java_00708_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_00708_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session already exists for user: " + userId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: No session exists for the given session id");
        } else {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");
        sessionManager.startSession("session1", "user3"); // Error: Session already exists for user: user3
        sessionManager.endSession("session1"); // Session ended for user: user1
        sessionManager.endSession("session3"); // Error: No session exists for the given session id
    }
}