import java.util.HashMap;
import java.util.Map;

public class java_42120_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_42120_SessionManager_A08() {
        sessionMap = new HashMap<>();
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

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void checkIntegrity(String sessionId) {
        if (!isSessionValid(sessionId)) {
            throw new SecurityException("Invalid session: " + sessionId);
        }
    }
}