import java.util.HashMap;
import java.util.Map;

public class java_18707_SessionManager_A08 {
    // Define a HashMap to store session data
    private Map<String, String> sessionData;

    // Constructor
    public java_18707_SessionManager_A08() {
        this.sessionData = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String data) {
        this.sessionData.put(sessionId, data);
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return this.sessionData.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        this.sessionData.remove(sessionId);
    }

    // Method to check if a session is valid
    public boolean isSessionValid(String sessionId) {
        // This is a placeholder for actual integrity check.
        // In a real system, you would likely need to check a signature on the session
        // to ensure that the session is still valid.
        return this.sessionData.containsKey(sessionId);
    }

    // Method to clear all sessions
    public void clearSessions() {
        this.sessionData.clear();
    }
}