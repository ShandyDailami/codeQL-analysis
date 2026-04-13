import java.util.HashMap;
import java.util.Map;

public class java_16864_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_16864_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a very basic session id generation for demonstration purposes
        // In a real world scenario, you would want to use a UUID or some other unique identifier
        return Long.toString(System.currentTimeMillis());
    }
}