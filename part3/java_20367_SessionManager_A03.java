import java.util.HashMap;

public class java_20367_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_20367_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}