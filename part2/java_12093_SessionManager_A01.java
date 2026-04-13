import java.util.HashMap;
import java.util.Map;

public class java_12093_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_12093_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return sessionMap.containsKey(sessionId);
    }
}