import java.util.HashMap;
import java.util.Map;

public class java_33591_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_33591_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void clearSessions() {
        sessionMap.clear();
    }
}