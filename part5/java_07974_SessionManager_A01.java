import java.util.HashMap;
import java.util.Map;

public class java_07974_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_07974_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new RuntimeException("Invalid session id");
        }
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        String userId = sessionManager.getUserId(sessionId);
        System.out.println("User in session: " + userId);

        sessionManager.removeSession(sessionId);
        System.out.println("Removed session: " + sessionId);
    }
}