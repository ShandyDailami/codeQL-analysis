import java.util.HashMap;
import java.util.Map;

public class java_04588_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_04588_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a real session ID generation algorithm
        // in a real-world application, session IDs should ideally be 
        // randomly generated and should be unique within the lifetime of a user.
        // For the sake of simplicity, this example will just return a static string.
        return "sessionId";
    }
}