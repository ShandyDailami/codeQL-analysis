import java.util.HashMap;
import java.util.Map;

public class java_39050_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_39050_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        // Create a session ID and store it in the session map
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        System.out.println("Started session for user: " + username);
    }

    public void endSession(String sessionId) {
        // Remove the session from the session map
        String username = sessions.get(sessionId);
        sessions.remove(sessionId);
        System.out.println("Ended session for user: " + username);
    }

    public String getUsername(String sessionId) {
        // Get the username from the session map
        return sessions.get(sessionId);
    }
}