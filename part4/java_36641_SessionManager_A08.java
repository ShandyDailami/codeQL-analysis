import java.util.HashMap;
import java.util.Map;

public class java_36641_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_36641_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Created session: " + sessionId + " for user: " + userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Destroyed session: " + sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a new session
        sessionManager.createSession("session1", "user1");

        // Getting the user ID associated with the session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID associated with session1: " + userId);

        // Destroying the session
        sessionManager.destroySession("session1");
    }
}