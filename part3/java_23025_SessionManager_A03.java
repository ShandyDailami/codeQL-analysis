import java.util.HashMap;
import java.util.Map;

public class java_23025_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_23025_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public void updateSession(String sessionId, String newValue) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newValue);
        }
    }
}