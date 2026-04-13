import java.util.HashMap;
import java.util.Map;

public class java_21675_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21675_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) {
        if (sessionMap.get(sessionId) == null) {
            throw new AuthFailureException("Invalid Session ID");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session for a user
        String username = "testUser";
        String sessionId = "12345";
        sessionManager.createSession(username, sessionId);

        // Validate the session
        sessionManager.validateSession(sessionId);

        // Get the username from the session
        String retrievedUsername = sessionManager.getUsername(sessionId);
        System.out.println("Retrieved Username: " + retrievedUsername);

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}