import java.util.HashMap;

public class java_07198_SessionManager_A07 {
    // Using HashMap as session storage
    private HashMap<String, String> sessions;

    public java_07198_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId1 = "session1";
        String userId1 = "user1";
        sessionManager.createSession(sessionId1, userId1);

        // Retrieve a session
        String userId2 = sessionManager.getSession(sessionId1);
        System.out.println("User ID from session: " + userId2);

        // Remove a session
        sessionManager.removeSession(sessionId1);
    }
}