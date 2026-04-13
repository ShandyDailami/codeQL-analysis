import java.util.HashMap;

public class java_29353_SessionManager_A03 {
    // A HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor to initialize the session map
    public java_29353_SessionManager_A03() {
        this.sessionMap = new HashMap<String, String>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        // Check if sessionId already exists
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists!";
        }

        // If not, create the session
        sessionMap.put(sessionId, sessionId);
        return "Session created!";
    }

    // Method to destroy a session
    public String destroySession(String sessionId) {
        // Check if sessionId does not exist
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: No session found!";
        }

        // If so, destroy the session
        sessionMap.remove(sessionId);
        return "Session destroyed!";
    }

    // Method to get a session
    public String getSession(String sessionId) {
        // Check if sessionId does not exist
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: No session found!";
        }

        // If so, return the session
        return sessionMap.get(sessionId);
    }
}