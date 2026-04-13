import java.util.HashMap;
import java.util.Map;

public class java_11116_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_11116_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            String userId = sessions.get(sessionId);
            sessions.remove(sessionId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session found for user with id: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");

        sessionManager.endSession("session1");

        sessionManager.startSession("session3", "user3");
    }
}