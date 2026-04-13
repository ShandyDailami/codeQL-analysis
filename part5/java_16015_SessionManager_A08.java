import java.util.*;

public class java_16015_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16015_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        // A08_IntegrityFailure: Check if sessionId is already in use.
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists.");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // A08_IntegrityFailure: Check if sessionId is in use.
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist.");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // A08_IntegrityFailure: Check if sessionId is in use.
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist.");
        }
        sessionMap.remove(sessionId);
    }
}