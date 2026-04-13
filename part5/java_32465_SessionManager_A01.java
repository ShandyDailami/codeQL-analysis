import java.util.HashMap;
import java.util.Map;

public class java_32465_SessionManager_A01 {

    // A private HashMap where we store session data.
    private Map<String, String> sessionData;

    // Constructor: initialize the sessionData Map.
    public java_32465_SessionManager_A01() {
        this.sessionData = new HashMap<>();
    }

    // Method to add a session to the session data.
    public void addSession(String sessionId, String sessionData) {
        this.sessionData.put(sessionId, sessionData);
    }

    // Method to get the session data from the session data.
    public String getSessionData(String sessionId) {
        return this.sessionData.get(sessionId);
    }

    // Method to validate if a session is valid.
    public boolean isValidSession(String sessionId) {
        return this.sessionData.containsKey(sessionId);
    }

    // Method to invalidate a session.
    public void invalidateSession(String sessionId) {
        this.sessionData.remove(sessionId);
    }
}