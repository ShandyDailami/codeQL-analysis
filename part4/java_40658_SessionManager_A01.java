import java.util.HashMap;
import java.util.Map;

public class java_40658_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_40658_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // User 1 logs into the system
        String sessionId1 = sessionManager.createSession("User1");
        System.out.println("Session ID for User 1: " + sessionId1);

        // User 2 tries to access User 1's session
        if (sessionManager.isValidSession(sessionId1)) {
            String user = sessionManager.getUser(sessionId1);
            System.out.println("User accessing session: " + user);
        } else {
            System.out.println("Invalid session ID for User 2.");
        }

        // User 1 logs out
        sessionManager.destroySession(sessionId1);

        // User 2 tries to access session after logout
        if (sessionManager.isValidSession(sessionId1)) {
            String user = sessionManager.getUser(sessionId1);
            System.out.println("User after logout accessing session: " + user);
        } else {
            System.out.println("User 2's session has been destroyed.");
        }
    }
}