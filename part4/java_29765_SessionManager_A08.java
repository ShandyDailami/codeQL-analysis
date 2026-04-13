import java.util.HashMap;

public class java_29765_SessionManager_A08 {

    // Create a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    public java_29765_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionID) {
        // If a session with the given ID already exists, return null
        if (sessionMap.containsKey(sessionID)) {
            return null;
        }
        // Otherwise, store the session ID in the HashMap and return it
        else {
            sessionMap.put(sessionID, sessionID);
            return sessionID;
        }
    }

    // Method to get a session
    public String getSession(String sessionID) {
        // If the session ID is in the HashMap, return the session ID
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        }
        // Otherwise, return null
        else {
            return null;
        }
    }

    // Method to delete a session
    public boolean deleteSession(String sessionID) {
        // If the session ID is in the HashMap, remove it and return true
        if (sessionMap.containsKey(sessionID)) {
            sessionMap.remove(sessionID);
            return true;
        }
        // Otherwise, return false
        else {
            return false;
        }
    }
}