import java.util.HashMap;
import java.util.Map;

public class java_34816_SessionManager_A08 {
    // A map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_34816_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String username) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username for a given session
    public String getUsernameForSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}