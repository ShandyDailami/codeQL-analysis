import java.util.HashMap;

public class java_25850_SessionManager_A08 {
    // A HashMap to store session data
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_25850_SessionManager_A08() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to create a session
    public String createSession(String sessionID) {
        // Check if the session ID is already in use
        if (sessionMap.containsKey(sessionID)) {
            return "A session with this ID already exists";
        }
        
        // Otherwise, add the session ID to the HashMap
        sessionMap.put(sessionID, "Active");
        
        return "Session created successfully";
    }

    // Method to destroy a session
    public String destroySession(String sessionID) {
        // Check if the session ID is not in use
        if (!sessionMap.containsKey(sessionID)) {
            return "A session with this ID does not exist";
        }

        // Otherwise, remove the session ID from the HashMap
        sessionMap.remove(sessionID);

        return "Session destroyed successfully";
    }

    // Method to verify a session
    public String verifySession(String sessionID) {
        // Check if the session ID is in use
        if (!sessionMap.containsKey(sessionID)) {
            return "A session with this ID does not exist";
        }

        return "Session exists";
    }
}