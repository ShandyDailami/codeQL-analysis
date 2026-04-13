import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_20315_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_20315_SessionManager_A03() {
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

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}