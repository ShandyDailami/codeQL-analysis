import java.util.HashMap;
import java.util.Map;

public class java_05856_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05856_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Started session with ID: " + sessionId + ", User ID: " + userId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session with ID: " + sessionId + ", User ID: " + userId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public void changeUser(String sessionId, String newUserId) {
        if (sessionMap.containsKey(sessionId)) {
            String currentUserId = sessionMap.get(sessionId);
            sessionMap.put(sessionId, newUserId);
            System.out.println("Changed user in session with ID: " + sessionId + ", from User ID: " + currentUserId + " to User ID: " + newUserId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        // Start session for user 1
        sessionManager.startSession("session1", "user1");

        // Start session for user 2
        sessionManager.startSession("session2", "user2");

        // Change user in session 1 to user 3
        sessionManager.changeUser("session1", "user3");

        // End session 2
        sessionManager.endSession("session2");
    }
}