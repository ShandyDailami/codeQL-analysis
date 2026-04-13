import java.util.HashMap;
import java.util.Map;

public class java_33941_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33941_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId(); // this method should be implemented
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // this method is left as an example, not actually used in real world
    private String generateSessionId() {
        return "sessionId"; // this should be implemented in real world
    }
}