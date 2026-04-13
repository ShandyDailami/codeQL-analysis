import java.util.HashMap;

public class java_28903_SessionManager_A07 {

    // A HashMap to store session data
    private HashMap<String, String> sessionData = new HashMap<>();

    // Method to start a session
    public void startSession(String sessionId, String userId) {
        // Check if sessionId and userId are not null
        if (sessionId != null && userId != null) {
            sessionData.put(sessionId, userId);
        } else {
            System.out.println("Invalid session or user data. Please try again.");
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Check if sessionId is not null
        if (sessionId != null) {
            sessionData.remove(sessionId);
        } else {
            System.out.println("Invalid session. Please try again.");
        }
    }

    // Method to check if a session is active
    public boolean isSessionActive(String sessionId) {
        // Check if sessionId is not null and if it exists in the sessionData
        return (sessionId != null && sessionData.containsKey(sessionId));
    }

    // Method to get the userId from a session
    public String getUserIdFromSession(String sessionId) {
        // Check if sessionId is not null and if it exists in the sessionData
        if (sessionId != null && sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            System.out.println("Invalid session. Please try again.");
            return null;
        }
    }
}