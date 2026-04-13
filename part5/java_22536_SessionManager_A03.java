import java.util.HashMap;

public class java_22536_SessionManager_A03 {
    // Map to hold sessions
    private HashMap<String, String> sessionMap;

    public java_22536_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Check if sessionId already exists
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID already exists: " + sessionId);
            return null;
        }

        // Create new session and add to map
        sessionMap.put(sessionId, "Created");

        return sessionId;
    }

    // Method to retrieve session
    public String retrieveSession(String sessionId) {
        // Check if sessionId exists
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID does not exist: " + sessionId);
            return null;
        }

        // Retrieve session from map
        return sessionMap.get(sessionId);
    }

    // Method to delete session
    public void deleteSession(String sessionId) {
        // Check if sessionId exists
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID does not exist: " + sessionId);
            return;
        }

        // Delete session from map
        sessionMap.remove(sessionId);
    }
}