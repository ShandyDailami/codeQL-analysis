import java.util.HashMap;
import java.util.Map;

public class java_05568_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_05568_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
        System.out.println("Session created for user: " + userId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }

    public void deleteSession(String userId) {
        sessions.remove(userId);
        System.out.println("Session deleted for user: " + userId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("user1", "session1");
        System.out.println("Session ID for user1: " + sessionManager.getSession("user1"));

        // Attempting to access a session that does not exist
        System.out.println("Session ID for user2: " + sessionManager.getSession("user2"));

        // Trying to delete a session that does not exist
        sessionManager.deleteSession("user2");

        sessionManager.deleteSession("user1");
    }
}