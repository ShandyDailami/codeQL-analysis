import java.util.HashMap;
import java.util.Map;

public class java_26373_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_26373_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session already started. Session ID: " + sessionId);
        }

        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No session found for the given session ID. Session ID: " + sessionId);
        }

        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No session found for the given session ID. Session ID: " + sessionId);
        }

        sessionMap.remove(sessionId);
    }
}