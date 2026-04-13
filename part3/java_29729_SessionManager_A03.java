import java.util.HashMap;
import java.util.Map;

public class java_29729_SessionManager_A03 {
    // A map to store session ids and their corresponding objects
    private Map<String, Object> sessionMap;

    public java_29729_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Object sessionObject) {
        // Generate a random session id
        String sessionId = "SESSION_" + System.currentTimeMillis();

        // Store the session object in the session map
        sessionMap.put(sessionId, sessionObject);

        return sessionId;
    }

    // Method to get a session
    public Object getSession(String sessionId) {
        // Check if the session id exists in the session map
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // If the session id does not exist, return null
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }
}