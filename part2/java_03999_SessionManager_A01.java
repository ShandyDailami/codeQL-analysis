import java.util.HashMap;
import java.util.Map;

public class java_03999_SessionManager_A01 {

    // Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_03999_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String user) {
        // Generate a session id
        String sessionId = generateSessionId();

        // Store the session id and user in the session map
        sessionMap.put(sessionId, user);

        // Return the session id
        return sessionId;
    }

    // Method to get a user from a session
    public String getUser(String sessionId) {
        // Return the user from the session map
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session id from the session map
        sessionMap.remove(sessionId);
    }

    // Method to generate a session id
    private String generateSessionId() {
        // This is a placeholder, in a real-world scenario, you would use a UUID
        return "sessionId";
    }
}