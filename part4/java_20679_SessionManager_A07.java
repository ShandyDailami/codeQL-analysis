import java.util.HashMap;
import java.util.Map;

public class java_20679_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_20679_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSessionValidity(String sessionId) {
        if (getUsername(sessionId) == null) {
            throw new AuthenticationFailureException("Invalid session: " + sessionId);
        }
    }

    public static class AuthenticationFailureException extends RuntimeException {
        public java_20679_SessionManager_A07(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        // Get the username from the session
        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username from session: " + username);

        // Check the validity of the session
        sessionManager.checkSessionValidity(sessionId);

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}