import java.util.HashMap;

public class java_12084_SessionManager_A08 {
    // Create a private instance of HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor to initialize session map
    public java_12084_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Check if the sessionId is already in use
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists!";
        } else {
            sessionMap.put(sessionId, "Session data");
            return "Success: Session created!";
        }
    }

    // Method to retrieve session data
    public String getSessionData(String sessionId) {
        // Check if the sessionId is in use
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session does not exist!";
        }
    }

    // Method to delete session
    public String deleteSession(String sessionId) {
        // Check if the sessionId is in use
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Success: Session deleted!";
        } else {
            return "Error: Session does not exist!";
        }
    }

    // Method to update session data
    public String updateSessionData(String sessionId, String sessionData) {
        // Check if the sessionId is in use
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, sessionData);
            return "Success: Session data updated!";
        } else {
            return "Error: Session does not exist!";
        }
    }
}