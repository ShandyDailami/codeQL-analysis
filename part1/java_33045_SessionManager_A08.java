import java.util.HashMap;

public class java_33045_SessionManager_A08 {
    // Create a new HashMap to hold the sessions
    private HashMap<String, Object> sessionMap;

    // Default constructor
    public java_33045_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(Object sessionObject) {
        // Generate a new session ID
        String sessionID = UUID.randomUUID().toString();

        // Ensure the session ID is unique
        while (sessionMap.containsKey(sessionID)) {
            sessionID = UUID.randomUUID().toString();
        }

        // Add the session object to the session map with the generated ID
        sessionMap.put(sessionID, sessionObject);

        // Return the session ID
        return sessionID;
    }

    // Method to get a session
    public Object getSession(String sessionID) {
        // Check if the session ID exists in the map
        if (!sessionMap.containsKey(sessionID)) {
            // Throw a `NullPointerException` if the session ID does not exist
            throw new NullPointerException("Session ID does not exist: " + sessionID);
        }

        // Return the session object
        return sessionMap.get(sessionID);
    }

    // Method to remove a session
    public void removeSession(String sessionID) {
        // Check if the session ID exists in the map
        if (!sessionMap.containsKey(sessionID)) {
            // Throw a `NullPointerException` if the session ID does not exist
            throw new NullPointerException("Session ID does not exist: " + sessionID);
        }

        // Remove the session from the map
        sessionMap.remove(sessionID);
    }
}