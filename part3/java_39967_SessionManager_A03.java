import java.util.HashMap;
import java.util.Map;

public class java_39967_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_39967_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void updateSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionData);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}