import java.util.HashMap;
import java.util.Map;

public class java_11334_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11334_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists");
        } else {
            sessionMap.put(sessionId, "");
        }
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No such session");
        } else {
            sessionMap.remove(sessionId);
        }
    }

    public void authenticateSession(String sessionId, String credentials) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No such session");
        } else if (!sessionMap.get(sessionId).equals(credentials)) {
            throw new RuntimeException("Authentication failed");
        } else {
            // session is authenticated
        }
    }
}