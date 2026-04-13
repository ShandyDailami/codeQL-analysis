import java.util.HashMap;

public class java_21213_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_21213_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder, replace it with your actual session id generation logic
        return "sessionId";
    }
}