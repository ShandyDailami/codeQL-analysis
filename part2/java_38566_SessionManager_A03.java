import java.util.HashMap;
import java.util.Map;

public class java_38566_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_38566_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}