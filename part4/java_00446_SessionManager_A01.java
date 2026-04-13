import java.util.HashMap;
import java.util.Map;

public class java_00446_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_00446_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}