import java.util.HashMap;
import java.util.Map;

public class java_40980_SessionManager_A03 {
    private Map<String, Object> sessionMap;

    public java_40980_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Object sessionObject) {
        String sessionId = UUID.randomUUID().toString(); // generate a random session ID
        sessionMap.put(sessionId, sessionObject);
        return sessionId;
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}