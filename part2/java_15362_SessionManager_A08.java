import java.util.HashMap;

public class java_15362_SessionManager_A08 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_15362_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession() {
        // Generate a new session ID
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionID, "Created");
        return sessionID;
    }

    // Method to destroy an existing session
    public void destroySession(String sessionID) {
        // Check if the session exists in the map
        if (sessionMap.containsKey(sessionID)) {
            sessionMap.remove(sessionID);
        }
    }

    // Method to get the state of a session
    public String getSessionState(String sessionID) {
        // Check if the session exists in the map
        if (sessionMap.containsKey(sessionID)) {
            // Return the state of the session
            return sessionMap.get(sessionID);
        } else {
            return "Session not found";
        }
    }
}