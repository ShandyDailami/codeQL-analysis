import java.util.HashMap;

public class java_16522_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_16522_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate session IDs here. This is just for demonstration.
    private String generateSessionId() {
        // This is a simple example, in a real-world application, you'd likely use a UUID.
        return String.valueOf(System.currentTimeMillis());
    }
}