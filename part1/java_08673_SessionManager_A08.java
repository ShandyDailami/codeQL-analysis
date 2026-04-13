import java.util.HashMap;
import java.util.Map;

public class java_08673_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_08673_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Creating session id based on userId and current timestamp
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // A simple method for demonstration purposes
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Created session ID: " + sessionId);
        System.out.println("User in session: " + sessionManager.getUserId(sessionId));

        // Delete session
        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session ID: " + sessionId);
    }
}