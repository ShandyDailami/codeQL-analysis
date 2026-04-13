import java.util.HashMap;
import java.util.Map;

public class java_38549_SessionManager_A03 {

    // Create a map to store sessions.
    private Map<String, String> sessionMap;

    public java_38549_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists for the provided ID.");
        }
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to retrieve the data associated with a session.
    public String getDataFromSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists for the provided ID.");
        }
        return sessionMap.get(sessionId);
    }

    // Method to update the data associated with a session.
    public void updateDataInSession(String sessionId, String newData) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists for the provided ID.");
        }
        sessionMap.put(sessionId, newData);
    }

    // Method to delete a session.
    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists for the provided ID.");
        }
        sessionMap.remove(sessionId);
    }
}