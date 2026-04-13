import java.util.HashMap;
import java.util.UUID;

public class java_12658_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_12658_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, "Active");
        return sessionId;
    }

    // Method to check if a session is active
    public boolean isSessionActive(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId).equals("Active");
        } else {
            return false;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, "Inactive");
        }
    }
}