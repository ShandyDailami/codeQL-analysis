import java.util.HashMap;
import java.util.Map;

public class java_07115_SessionManager_A01 {
    // A private Map to hold the session data
    private Map<String, String> sessionData;

    // Default constructor
    public java_07115_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    // Method to set session data
    public void setSessionData(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    // Method to get session data
    public String getSessionData(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Method to remove session data
    public void removeSessionData(String sessionId) {
        sessionData.remove(sessionId);
    }
}