import java.util.HashMap;
import java.util.Map;

public class java_37968_SessionManager_A01 {

    // Create a new hashmap for the sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_37968_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Check if session id is already in use
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists";
        }

        // Add session id and value to the map
        sessionMap.put(sessionId, sessionId);

        return "Session created successfully";
    }

    // Method to retrieve a session
    public String getSession(String sessionId) {
        // Check if session id exists in the map
        if (!sessionMap.containsKey(sessionId)) {
            return "Session not found";
        }

        // Return the session id
        return sessionMap.get(sessionId);
    }

    // Method to close a session
    public String closeSession(String sessionId) {
        // Check if session id exists in the map
        if (!sessionMap.containsKey(sessionId)) {
            return "Session not found";
        }

        // Remove the session id from the map
        sessionMap.remove(sessionId);

        return "Session closed successfully";
    }
}