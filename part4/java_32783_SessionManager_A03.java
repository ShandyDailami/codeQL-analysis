import java.util.HashMap;
import java.util.Map;

public class java_32783_SessionManager_A03 {
    // We use a HashMap to store sessions.
    private Map<String, String> sessionMap;

    // Constructor
    public java_32783_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    // Method to get a session value
    public String getSessionValue(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}