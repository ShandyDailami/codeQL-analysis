import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_00130_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private Map<String, Boolean> expiryMap;

    public java_00130_SessionManager_A01() {
        sessionMap = new HashMap<>();
        expiryMap = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, sessionId);
        expiryMap.put(sessionId, false);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
        expiryMap.remove(sessionId);
    }

    public void expireSession(String sessionId) {
        expiryMap.put(sessionId, true);
    }

    public String getSession(String sessionId) {
        if(expiryMap.get(sessionId)) {
            deleteSession(sessionId);
            return null;
        }
        return sessionId;
    }
}