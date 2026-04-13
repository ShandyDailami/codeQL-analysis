import java.util.Map;
import java.util.HashMap;

public class java_19791_SessionManager_A03 {

    // The session data is stored in a map
    private Map<String, String> sessionData;

    // Constructor
    public java_19791_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    // Method to add a session data
    public void addSessionData(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    // Method to get a session data
    public String getSessionData(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Simulate a security-sensitive operation related to injection
    public void setSessionData(String sessionId, String newData) {
        // Set session data to a new value without checking for injection
        sessionData.put(sessionId, newData);
    }

    // Method to check if a session is valid
    public boolean isSessionValid(String sessionId) {
        // Simulate a security-sensitive operation to check if the session is valid
        return sessionData.containsKey(sessionId);
    }
}