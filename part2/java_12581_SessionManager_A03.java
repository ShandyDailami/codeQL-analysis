import java.util.HashMap;
import java.util.Map;

public class java_12581_SessionManager_A03 {

    // A map to hold sessions. Key is session ID, value is session data.
    private Map<String, String> sessionMap;

    public java_12581_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session. Returns session ID.
    public String startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get session data.
    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session.
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to generate a session ID.
    private String generateSessionId() {
        // Here, we'll use simple random session ID for simplicity. In a real app, you'd likely use UUIDs or similar.
        return String.valueOf(System.currentTimeMillis());
    }
}