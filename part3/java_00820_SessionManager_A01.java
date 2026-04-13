import java.util.concurrent.ConcurrentHashMap;

public class java_00820_SessionManager_A01 {
    private ConcurrentHashMap<String, String> sessionMap;

    public java_00820_SessionManager_A01() {
        sessionMap = new ConcurrentHashMap<>();
    }

    public void createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}