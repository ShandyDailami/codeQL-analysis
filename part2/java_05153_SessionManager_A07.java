import java.util.HashMap;

public class java_05153_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_05153_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId) {
        String sessionId = generateSessionId(userId);
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId(String userId) {
        // This is a simple example of a session id generation. In a real-world scenario, you'd want to use a more complex algorithm.
        return userId;
    }
}