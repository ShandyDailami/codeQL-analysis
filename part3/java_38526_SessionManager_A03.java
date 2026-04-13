import java.util.HashMap;
import java.util.Map;

public class java_38526_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_38526_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        // Generate a session id here. This is a simple example.
        // In a real-world application, the session id should be securely generated.
        String sessionId = "session_" + username;
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Test the session manager
        String username = "john";
        String sessionId = sessionManager.getSessionId(username);
        System.out.println("Session ID: " + sessionId);
        System.out.println("Username: " + sessionManager.getUsername(sessionId));

        // Invalidate the session
        sessionManager.invalidateSession(sessionId);
        System.out.println("Username after invalidation: " + sessionManager.getUsername(sessionId));
    }
}