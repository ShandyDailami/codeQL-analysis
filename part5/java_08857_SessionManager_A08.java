import java.util.HashMap;
import java.util.Map;

public class java_08857_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_08857_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public void addSession(String sessionId, String username) {
        // Add session and username to the map
        sessions.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        // Return the username from the map, or null if the session is not valid
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Delete the session from the map
        sessions.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        // Check if the session is valid (i.e., it exists in the map)
        return sessions.containsKey(sessionId);
    }
}