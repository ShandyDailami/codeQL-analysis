import java.util.HashMap;

public class java_21625_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_21625_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}