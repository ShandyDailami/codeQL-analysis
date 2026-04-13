import java.util.HashMap;

public class java_41916_SessionManager_A08 {
    private HashMap<String, String> sessionData;

    public java_41916_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionData.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple method to generate a session ID. In a real scenario,
        // you would probably use a UUID, or a combination of user IDs and timestamps.
        // For the purpose of this example, we're just using a string ID.
        return "" + System.currentTimeMillis();
    }
}