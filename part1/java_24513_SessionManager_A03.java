import java.util.HashMap;
import java.util.Map;

public class java_24513_SessionManager_A03 {
    // Data structure to store session data
    private Map<String, Object> sessionData;

    // Default constructor
    public java_24513_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    // Method to create a new session
    public void createSession(String sessionId) {
        sessionData.put(sessionId, null);
    }

    // Method to set data in a session
    public void setSessionData(String sessionId, Object data) {
        sessionData.put(sessionId, data);
    }

    // Method to get data from a session
    public Object getSessionData(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}