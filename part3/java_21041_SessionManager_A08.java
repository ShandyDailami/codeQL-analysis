import java.util.HashMap;
import java.util.Map;

public class java_21041_SessionManager_A08 {
    // A map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_21041_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        this.sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user associated with a session
    public String getUser(String sessionId) {
        if (this.sessionMap.containsKey(sessionId)) {
            return this.sessionMap.get(sessionId);
        } else {
            throw new SecurityFailureException("Session ID not found"); // Throw an exception if session ID is not found
        }
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        if (this.sessionMap.containsKey(sessionId)) {
            this.sessionMap.remove(sessionId);
        } else {
            throw new SecurityFailureException("Session ID not found"); // Throw an exception if session ID is not found
        }
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return this.sessionMap.containsKey(sessionId);
    }
}