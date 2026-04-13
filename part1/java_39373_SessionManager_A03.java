import java.util.HashMap;

public class java_39373_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_39373_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId(userId);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId(String userId) {
        // TODO: Implement session id generation logic here.
        // For simplicity, we'll just return the userId.
        return userId;
    }
}