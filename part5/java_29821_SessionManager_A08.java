import java.util.HashMap;

public class java_29821_SessionManager_A08 {
    // Using a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Session Manager constructor
    public java_29821_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the user ID from a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}