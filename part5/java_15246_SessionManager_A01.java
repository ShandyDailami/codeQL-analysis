import java.util.HashMap;
import java.util.Map;

public class java_15246_SessionManager_A01 {
    // Using a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_15246_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user for a session
    public String getUserForSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end the session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}