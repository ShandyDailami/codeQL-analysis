import java.util.HashMap;
import java.util.Map;

public class java_37991_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_37991_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean deleteSession(String sessionId) {
        return sessionMap.remove(sessionId) != null;
    }
}