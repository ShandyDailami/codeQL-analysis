import java.util.HashMap;
import java.util.Map;

public class java_04872_SessionManager_A08 {
    // Using a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_04872_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userID) {
        String sessionID = generateSessionID(); // this could be a random session id
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to get the userID for a given sessionID
    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Method to close a session
    public void closeSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    // Utility method to generate a session id
    private String generateSessionID() {
        // this could be a long random number or UUID
        return Long.toString(System.nanoTime());
    }
}