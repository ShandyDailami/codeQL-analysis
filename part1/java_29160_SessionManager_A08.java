import java.util.HashMap;

public class java_29160_SessionManager_A08 {
    // HashMap to store the sessions
    private HashMap<String, String> sessionMap;

    public java_29160_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString(); // Generate a new UUID for session
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user from a session
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate the session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}