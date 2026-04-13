import java.util.HashMap;

public class java_16013_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_16013_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Helper method to generate a random sessionId
    private String generateSessionId() {
        // Assuming sessionId is a unique identifier for each session,
        // in a real-world application, you would probably generate it in a secure way
        return "sessionId";
    }
}