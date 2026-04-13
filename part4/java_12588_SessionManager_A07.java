import java.util.HashMap;

public class java_12588_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_12588_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis(); // This is a simple way to create a unique session ID. In a real application, you would likely use UUIDs or similar to ensure uniqueness across all sessions.
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to retrieve the user ID associated with a given session
    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Method to end a session
    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}