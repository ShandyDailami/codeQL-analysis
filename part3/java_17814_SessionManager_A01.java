import java.util.HashMap;

public class java_17814_SessionManager_A01 {
    // This is a simple hash map that will hold the sessions
    private HashMap<String, String> sessionMap;

    // Default constructor
    public java_17814_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userName) {
        // Generate a session id and store it in the hash map
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session id exists in the hash map
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        // Remove the session id from the hash map
        sessionMap.remove(sessionId);
    }
}