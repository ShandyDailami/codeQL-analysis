import java.util.HashMap;
import java.util.Map;

public class java_36356_SessionManager_A03 {
    // Using a HashMap to store session data
    private Map<String, String> sessionMap;

    public java_36356_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, "");
        return sessionId;
    }

    // Method to update an existing session
    public void updateSession(String sessionId, String newValue) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newValue);
        }
    }

    // Method to retrieve session value
    public String getSessionValue(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}