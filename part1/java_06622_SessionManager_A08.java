import java.util.HashMap;
import java.util.Map;

public class java_06622_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_06622_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void openSession(String sessionId) throws SecurityException {
        if (sessionId == null) {
            throw new SecurityException("Session ID cannot be null!");
        }
        sessionMap.put(sessionId, "Session data");
    }

    public String getSession(String sessionId) throws SecurityException {
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID!");
        }
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) throws SecurityException {
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID!");
        }
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String newData) throws SecurityException {
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID!");
        }
        sessionMap.replace(sessionId, newData);
    }
}