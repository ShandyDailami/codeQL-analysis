import java.util.HashMap;
import java.util.Map;

public class java_17274_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_17274_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        System.out.println("Created session: " + sessionId + " for user: " + username);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        String username = sessions.get(sessionId);
        if (username != null) {
            sessions.remove(sessionId);
            System.out.println("Deleted session: " + sessionId + " for user: " + username);
        } else {
            System.out.println("No active session found for session ID: " + sessionId);
        }
    }
}