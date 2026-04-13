import java.util.HashMap;

public class java_12548_SessionManager_A07 {
    // Create a HashMap to hold session data
    private HashMap<String, String> sessionData;

    // SessionManager constructor
    public java_12548_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Method to start a session
    public void startSession(String sessionId, String userId) {
        sessionData.put(sessionId, userId);
    }

    // Method to get the userId associated with a session
    public String getUserIdFromSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}