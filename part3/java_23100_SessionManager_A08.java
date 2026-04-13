import java.util.HashMap;
import java.util.Map;

public class java_23100_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_23100_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get user id by session id
        String userIdBySession = sessionManager.getUserIdBySessionId(sessionId);
        System.out.println("User id by session id: " + userIdBySession);

        // Delete session
        sessionManager.deleteSession(sessionId);
    }
}