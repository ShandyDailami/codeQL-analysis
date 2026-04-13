import java.util.HashMap;
import java.util.Map;

public class java_33683_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_33683_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session for a user
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        // Validate the session
        if (sessionManager.validateSession(sessionId)) {
            // Get the username from the session
            String username = sessionManager.getUsername(sessionId);
            System.out.println("Validated session: " + username);

            // Invalidate the session
            sessionManager.invalidateSession(sessionId);
            System.out.println("Invalidated session: " + sessionId);
        } else {
            System.out.println("Invalid session: " + sessionId);
        }
    }
}