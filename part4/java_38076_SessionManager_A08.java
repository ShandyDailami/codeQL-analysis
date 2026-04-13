import java.util.HashMap;
import java.util.Map;

public class java_38076_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_38076_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session already exists: " + sessionId);
        }
        sessionMap.put(sessionId, sessionId);
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session does not exist: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session does not exist: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public void clearSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session does not exist: " + sessionId);
        }
        sessionMap.put(sessionId, sessionId); // To clear the session, we can put it back into the map.
    }
}