import java.util.HashMap;
import java.util.Map;

public class java_12786_SessionManager_A01 {

    // A HashMap to store the sessions
    private Map<String, String> sessionMap;

    // A user who can only access a session
    private String allowedUser;

    // The constructor
    public java_12786_SessionManager_A01(String allowedUser) {
        this.sessionMap = new HashMap<>();
        this.allowedUser = allowedUser;
    }

    // A method to create a session
    public String createSession(String user) {
        if (!user.equals(allowedUser)) {
            throw new IllegalArgumentException("Only the user can create a session");
        }

        // Generate a session ID
        String sessionId = String.valueOf(System.currentTimeMillis());

        // Store the session
        sessionMap.put(sessionId, user);

        return sessionId;
    }

    // A method to access a session
    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session not found");
        }

        return sessionMap.get(sessionId);
    }

    // A method to close a session
    public void closeSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session not found");
        }

        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}