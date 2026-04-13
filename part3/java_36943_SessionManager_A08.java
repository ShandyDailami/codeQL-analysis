import java.util.HashMap;
import java.util.Map;

public class java_36943_SessionManager_A08 {
    private Map<String, Object> sessionMap;

    public java_36943_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        // Validate the inputs
        if (sessionId == null || sessionObject == null) {
            throw new IllegalArgumentException("Session ID and session object must not be null");
        }

        // Check if a session with the same ID already exists
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("A session with the ID " + sessionId + " already exists");
        }

        // Add the session to the map
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        // Validate the input
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }

        // Check if the session exists in the map
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with the ID " + sessionId + " exists");
        }

        // Return the session object
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        // Validate the input
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }

        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}