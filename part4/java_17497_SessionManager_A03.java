import java.util.HashMap;
import java.util.Map;

public class java_17497_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_17497_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id " + sessionId);
        }
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with id " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with id " + sessionId);
        }
        return sessionMap.get(sessionId);
    }
}