import java.util.HashMap;
import java.util.Map;

public class java_13932_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_13932_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started with ID: " + sessionId + " and User ID: " + userId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId + " and User ID: " + userId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");
        sessionManager.endSession("session1");
        sessionManager.endSession("session3");
    }
}