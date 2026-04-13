import java.util.HashMap;
import java.util.Map;

public class java_36986_SessionManager_A07 {
    // A Map to hold session data. 
    private Map<String, String> sessionMap;

    // Constructor
    public java_36986_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        // Check if the session id already exists in the map. 
        // If it does, return an error message. 
        // If it doesn't, add the session id and the session data to the map and return a success message.
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists";
        } else {
            sessionMap.put(sessionId, "Session data");
            return "Success: Session created";
        }
    }

    // Method to retrieve data from a session
    public String getSessionData(String sessionId) {
        // Check if the session id exists in the map. 
        // If it does, return the session data. 
        // If it doesn't, return an error message.
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session does not exist";
        }
    }

    // Method to remove a session
    public String removeSession(String sessionId) {
        // Check if the session id exists in the map. 
        // If it does, remove the session id from the map and return a success message.
        // If it doesn't, return an error message.
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Success: Session removed";
        } else {
            return "Error: Session does not exist";
        }
    }
}