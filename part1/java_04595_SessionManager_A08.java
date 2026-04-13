import java.util.HashMap;
import java.util.Map;

public class java_04595_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_04595_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    public String getUserBySessionId(String sessionId) throws SecurityException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session id: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}