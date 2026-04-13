import java.util.HashMap;
import java.util.Map;

public class java_41273_SessionManager_A08 {

    // A simple in-memory data store for storing session data
    private Map<String, String> sessionData;

    public java_41273_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String userId) {
        sessionData.put(sessionId, userId);
        return sessionId;
    }

    // Method to retrieve the userId associated with a given session
    public String getSessionUser(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Method to check if a session exists
    public boolean isSessionValid(String sessionId) {
        return sessionData.containsKey(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    // Method to update the userId in a session
    public void updateSessionUser(String sessionId, String userId) {
        sessionData.replace(sessionId, userId);
    }
}