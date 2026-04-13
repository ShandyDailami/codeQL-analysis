import java.util.HashMap;
import java.util.Map;

public class java_16971_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16971_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple id generation, in a real application, you would want to use a more secure mechanism
        return "session" + System.currentTimeMillis();
    }
}