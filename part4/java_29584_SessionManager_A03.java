import java.util.HashMap;
import java.util.Map;

public class java_29584_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_29584_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionExist(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Session Manager should not be able to create, read, modify or delete the session
    // In this case, we will add a method to clear the session map.
    public void clearSessions() {
        sessionMap.clear();
    }
}