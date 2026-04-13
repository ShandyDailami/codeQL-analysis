import java.util.HashMap;

public class java_29235_SessionManager_A01 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessionMap = new HashMap<>();

    // Method to create a new session
    public String createSession(String user) {
        // Generate a session ID
        String sessionId = Integer.toString(sessionMap.size() + 1);

        // Store the session ID and user name in the map
        sessionMap.put(sessionId, user);

        return sessionId;
    }

    // Method to get a user name for a given session ID
    public String getUserNameForSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}