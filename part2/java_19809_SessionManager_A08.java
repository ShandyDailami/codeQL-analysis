import java.util.HashMap;

public class java_19809_SessionManager_A08 {

    // A HashMap to store session data
    private HashMap<String, String> sessionData;

    // Constructor
    public java_19809_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        String sessionId = generateSessionId();
        sessionData.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session
    public String getUserIdFromSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    // Method to generate a session id
    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }
}