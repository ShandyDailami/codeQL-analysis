import java.util.HashMap;

public class java_30151_SessionManager_A03 {
    // Use a HashMap to store sessions
    private HashMap<String, String> sessionMap = new HashMap<>();

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get the session
    public String getSession(String sessionId) {
        // Check if session exists
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to delete the session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}