import java.util.HashMap;
import java.util.Map;

public class java_21571_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_21571_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method generates a unique session id.
        // It's not really a session manager's responsibility to generate ids,
        // but it's just to make the code a bit more unique.
        return String.valueOf(System.nanoTime());
    }
}