import java.util.HashMap;
import java.util.Map;

public class java_09701_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09701_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}