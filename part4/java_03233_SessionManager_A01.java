import java.util.HashMap;
import java.util.Map;

public class java_03233_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_03233_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            // This sessionId is not found in the sessionMap, hence it's invalid
            throw new IllegalArgumentException("Invalid sessionId");
        }

        // Retrieve the session data
        return sessionMap.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        // Create a new session with the provided sessionId and sessionData
        sessionMap.put(sessionId, sessionData);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (!sessionMap.containsKey(sessionId)) {
            // This sessionId is not found in the sessionMap, hence it's invalid
            throw new IllegalArgumentException("Invalid sessionId");
        }

        // Update the session data
        sessionMap.replace(sessionId, newSessionData);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            // This sessionId is not found in the sessionMap, hence it's invalid
            throw new IllegalArgumentException("Invalid sessionId");
        }

        // Delete the session
        sessionMap.remove(sessionId);
    }
}