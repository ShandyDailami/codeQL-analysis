import java.util.HashMap;
import java.util.Map;

public class java_06480_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_06480_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // or throw an exception
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void deleteAllSessions() {
        sessionMap.clear();
    }
}