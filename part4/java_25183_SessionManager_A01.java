import java.util.HashMap;
import java.util.Map;

public class java_25183_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_25183_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        // A01_BrokenAccessControl: Check if sessionId is valid and not already in use.
        if (sessionId == null || sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID or session already in use.");
        }

        sessionMap.put(sessionId, username);
        System.out.println("Started session " + sessionId + " for user " + username);
    }

    public void endSession(String sessionId) {
        // A01_BrokenAccessControl: Check if sessionId is valid and is in use.
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID or session not in use.");
        }

        sessionMap.remove(sessionId);
        System.out.println("Ended session " + sessionId);
    }

    public String getUsername(String sessionId) {
        // A01_BrokenAccessControl: Check if sessionId is valid.
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID or session not in use.");
        }

        return sessionMap.get(sessionId);
    }
}