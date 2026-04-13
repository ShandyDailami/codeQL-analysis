import java.util.HashMap;
import java.util.Map;

public class java_29016_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_29016_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with ID: " + sessionId);
        }
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with ID: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void updateSessionData(String sessionId, String newSessionData) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with ID: " + sessionId);
        }
        sessionMap.put(sessionId, newSessionData);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with ID: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public void closeSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with ID: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }
}