import java.util.HashMap;

public class java_32128_SessionManager_A07 {
    // Using a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_32128_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String sessionID) {
        // Check if the session ID already exists
        if(sessionMap.containsKey(sessionID)) {
            System.out.println("Session ID already exists: " + sessionID);
            return null;
        }

        // If the session ID does not exist, add it to the map
        sessionMap.put(sessionID, "Active");

        // Return the session ID
        return sessionID;
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Check if the session ID exists
        if(!sessionMap.containsKey(sessionID)) {
            System.out.println("Session ID does not exist: " + sessionID);
            return;
        }

        // If the session ID does exist, remove it from the map
        sessionMap.remove(sessionID);
    }

    // Method to check if a session is active
    public String isSessionActive(String sessionID) {
        // Check if the session ID exists
        if(!sessionMap.containsKey(sessionID)) {
            System.out.println("Session ID does not exist: " + sessionID);
            return null;
        }

        // Return the status of the session
        return sessionMap.get(sessionID);
    }
}