import java.util.HashMap;
import java.util.Map;

public class java_33220_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_33220_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityFailureException("Invalid session ID: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityFailureException("Invalid session ID: " + sessionId);
        }
    }
}