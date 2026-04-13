import java.util.HashMap;
import java.util.Map;

public class java_39323_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39323_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    // Method to get the user name of a session
    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}