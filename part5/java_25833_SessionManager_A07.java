import java.util.HashMap;
import java.util.Map;

public class java_25833_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_25833_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        System.out.println("Started session for user " + username + " with ID " + sessionId);
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessions.get(sessionId);
        sessions.remove(sessionId);
        System.out.println("Ended session for user " + username);
    }
}