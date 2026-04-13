import java.util.HashMap;
import java.util.Map;

public class java_27062_SessionManager_A03 {
    // A map to simulate a session storage
    private Map<String, Object> sessionMap;

    // Constructor
    public java_27062_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Object sessionObject) {
        // Generate a session ID
        String sessionId = "session_" + System.currentTimeMillis();

        // Store the session object in the session map
        sessionMap.put(sessionId, sessionObject);

        return sessionId;
    }

    // Method to retrieve a session
    public Object getSession(String sessionId) {
        // Check if the session ID exists in the map
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}