import java.util.HashMap;

public class java_37966_SessionManager_A03 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    public java_37966_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessionMap.put(sessionId, "Session data for " + sessionId);
        return sessionId;
    }

    // Method to retrieve session data
    public String getSessionData(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        String sessionData = sessionMap.get(sessionId);
        return sessionData;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessionMap.remove(sessionId);
    }
}