import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_39203_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_39203_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}