import java.util.Map;

public class java_07796_SessionManager_A03 {
    private Map<String, String> sessionMap;
    private ThreadLocal<String> sessionThreadLocal;

    public java_07796_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
        this.sessionThreadLocal = new ThreadLocal<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        sessionThreadLocal.set(sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
        sessionThreadLocal.remove();
    }
}