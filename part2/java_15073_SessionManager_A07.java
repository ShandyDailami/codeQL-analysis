import java.util.HashMap;
import java.util.Map;

public class java_15073_SessionManager_A07 {

    // private map to store sessions
    private Map<String, String> sessionMap;

    // constructor
    public java_15073_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // method to add session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // method to check if session exists
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // method to remove session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // method to verify if a user is authenticated
    public boolean isAuthenticated(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}