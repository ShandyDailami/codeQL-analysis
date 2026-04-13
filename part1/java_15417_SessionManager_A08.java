import java.util.*;

public class java_15417_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_15417_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Creating session
        String sessionId = sm.createSession("user1");
        System.out.println("Created session: " + sessionId);

        // Getting user id
        String userId = sm.getUserId(sessionId);
        System.out.println("User ID: " + userId);

        // Deleting session
        sm.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}