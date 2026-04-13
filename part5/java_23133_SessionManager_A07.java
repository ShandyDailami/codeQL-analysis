import java.util.HashMap;
import java.util.Map;

public class java_23133_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_23133_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Session created: " + sessionId);

        // Get the user ID associated with the session
        String userId = sessionManager.getUserId(sessionId);
        System.out.println("User ID associated with session: " + userId);

        // Delete the session
        sessionManager.deleteSession(sessionId);
        System.out.println("Session deleted: " + sessionId);
    }
}