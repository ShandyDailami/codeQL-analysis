import java.util.HashMap;
import java.util.Map;

public class java_19751_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19751_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }
}

public class BrokenAccessControlExample {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Attempting to create a session
        sessionManager.createSession("user1", "session1");

        // Accessing the session
        String session = sessionManager.getSession("user1");
        System.out.println("Accessed session: " + session);

        // Attempting to delete the session
        sessionManager.deleteSession("user1");

        // Accessing the deleted session
        session = sessionManager.getSession("user1");
        System.out.println("Deleted session: " + session);
    }
}