import java.util.HashMap;
import java.util.Map;

public class java_04751_SessionManager_A08 {

    // A map to simulate a database
    private Map<String, String> sessionDB;

    // Constructor to initialize the sessionDB
    public java_04751_SessionManager_A08() {
        sessionDB = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String username) {
        String sessionId = "A08_IntegrityFailure-" + System.currentTime();
        sessionDB.put(sessionId, username);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionDB.remove(sessionId);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionDB.containsKey(sessionId);
    }

    // Method to get the username from a session
    public String getUsername(String sessionId) {
        if (isValidSession(sessionId)) {
            return sessionDB.get(sessionId);
        } else {
            return null; // or throw an exception
        }
    }
}