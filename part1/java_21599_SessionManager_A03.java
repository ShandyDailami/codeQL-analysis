import java.util.HashMap;

public class java_21599_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_21599_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get the userId from a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Auxiliary method to generate a session id
    private String generateSessionId() {
        // TODO: You can generate a random session id, or use a UUID
        // For now, let's just return a simple session id
        return "session1";
    }
}