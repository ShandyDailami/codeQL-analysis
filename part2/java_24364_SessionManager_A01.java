import java.util.HashMap;
import java.util.Map;

public class java_24364_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_24364_SessionManager_A01() {
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

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simplistic session ID generator. In a real application, you would
        // use a UUID or some other method of generating unique identifiers.
        return String.valueOf(System.currentTimeMillis());
    }
}