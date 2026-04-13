import java.util.HashMap;
import java.util.Map;

public class java_29371_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_29371_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Please login to continue.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started. User ID: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended. User ID: " + userId);
        } else {
            System.out.println("No active session found. Please start session first.");
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