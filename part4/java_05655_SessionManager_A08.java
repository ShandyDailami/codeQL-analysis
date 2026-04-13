import java.util.HashMap;
import java.util.Map;

public class java_05655_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05655_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        // Create session by putting sessionId and sessionValue in sessionMap
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        // Retrieve sessionValue by sessionId from sessionMap
        // This is a security-sensitive operation, throw an exception if sessionId is not found
        String sessionValue = sessionMap.get(sessionId);
        if (sessionValue == null) {
            throw new SecurityFailureException("Session integrity failure: Invalid session ID");
        }
        return sessionValue;
    }

    public void deleteSession(String sessionId) {
        // Delete session by sessionId from sessionMap
        sessionMap.remove(sessionId);
    }
}