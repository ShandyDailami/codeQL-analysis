import java.util.HashMap;
import java.util.Map;

public class java_27279_SessionManager_A07 {

    // A HashMap to store session data
    private Map<String, String> sessionData;

    public java_27279_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // If sessionId is already in use, return an error message
        if (sessionData.containsKey(sessionId)) {
            return "Error: Session ID already in use";
        }

        // Otherwise, add the sessionId and sessionData to the map
        sessionData.put(sessionId, "Session Data");

        return "Successfully created session with ID: " + sessionId;
    }

    // Method to get session data
    public String getSessionData(String sessionId) {
        // If sessionId is not in use, return an error message
        if (!sessionData.containsKey(sessionId)) {
            return "Error: Session ID not found";
        }

        // Otherwise, return the sessionData
        return sessionData.get(sessionId);
    }

    // Method to delete session
    public String deleteSession(String sessionId) {
        // If sessionId is not in use, return an error message
        if (!sessionData.containsKey(sessionId)) {
            return "Error: Session ID not found";
        }

        // Otherwise, remove the sessionId from the map
        sessionData.remove(sessionId);

        return "Successfully deleted session with ID: " + sessionId;
    }
}