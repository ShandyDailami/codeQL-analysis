import java.util.HashMap;
import java.util.Map;

public class java_30081_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_30081_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class SecurityTest {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = "A07_AuthFailure";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get the user from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User: " + user);

        // Invalidate the session
        sessionManager.invalidateSession(sessionId);

        // Try to get the user from the invalided session
        user = sessionManager.getUserId(sessionId);
        System.out.println("User after session invalidation: " + user);
    }
}