import java.util.HashMap;
import java.util.Map;

public class java_00397_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_00397_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if (sessions.containsKey(userId)) {
            System.out.println("Session already exists for user: " + userId);
        } else {
            sessions.put(userId, sessionId);
            System.out.println("New session started for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessions.containsKey(userId)) {
            sessions.remove(userId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session exists for user: " + userId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("user1", "session1");
        sessionManager.startSession("user2", "session2");
        sessionManager.endSession("user1");
        sessionManager.startSession("user3", "session3");
    }
}