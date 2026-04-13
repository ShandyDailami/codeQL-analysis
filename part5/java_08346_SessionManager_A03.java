import java.util.Map;
import java.util.HashMap;

public class java_08346_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_08346_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}