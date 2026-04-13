import java.util.HashMap;

public class java_31984_SessionManager_A03 {
    // HashMap to store session data
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_31984_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionId, userName); // Store the session ID and user name in the HashMap
        return sessionId;
    }

    // Method to get the user name for a given session ID
    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate a session ID
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId); // Check if the session ID exists in the HashMap
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId); // Remove the session ID from the HashMap
    }
}