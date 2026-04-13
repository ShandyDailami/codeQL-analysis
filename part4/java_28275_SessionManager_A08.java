import java.util.HashMap;
import java.util.Map;

public class java_28275_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_28275_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // Add session ID and user ID to the map
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // Validate if the session is valid (i.e., it's in the map)
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        }
        return null;
    }

    public void endSession(String sessionId) {
        // Remove the session from the map
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Start a session for user1
        manager.startSession("session1", "user1");

        // Get the user id from the session
        String userId = manager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // End the session
        manager.endSession("session1");
    }
}