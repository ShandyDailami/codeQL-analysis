import java.util.HashMap;
import java.util.Map;

public class java_23142_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_23142_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessions.containsKey(username)) {
            System.out.println("Error: Session already exists for user " + username);
            return;
        }
        String sessionId = generateSessionId();
        sessions.put(sessionId, username);
        System.out.println("Session started for user " + username + ". Session ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("Error: No session found for session ID " + sessionId);
            return;
        }
        String username = sessions.get(sessionId);
        sessions.remove(sessionId);
        System.out.println("Session ended for user " + username + ". Session ID: " + sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder method. You should replace it with a secure method for generating session IDs.
        return "sessionId";
    }
}