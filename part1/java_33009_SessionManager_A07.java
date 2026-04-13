import java.util.HashMap;
import java.util.Map;

public class java_33009_SessionManager_A07 {

    // Create a map to store session data
    private Map<String, Object> sessionMap = new HashMap<>();

    // Method to create a session
    public String createSession(String userId) {
        sessionMap.put(userId, userId);
        return userId;
    }

    // Method to retrieve a user from a session
    public Object getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Create a session
        String sessionId = sm.createSession("A07_AuthFailure");
        System.out.println("Created session with id: " + sessionId);

        // Retrieve the user from the session
        Object user = sm.getUserFromSession(sessionId);
        System.out.println("Retrieved user from session: " + user.toString());

        // Destroy the session
        sm.destroySession(sessionId);
        System.out.println("Destroyed session with id: " + sessionId);
    }
}