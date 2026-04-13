import java.util.HashMap;
import java.util.Map;

public class java_25259_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_25259_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionId == null || userId == null) {
            throw new IllegalArgumentException("Session Id and User Id must be provided.");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session Id must be provided.");
        }
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session Id must be provided.");
        }
        sessionMap.remove(sessionId);
    }
}