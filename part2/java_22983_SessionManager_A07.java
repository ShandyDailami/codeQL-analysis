import java.util.HashMap;
import java.util.Map;

public class java_22983_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_22983_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString(); // generate a random session id
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}