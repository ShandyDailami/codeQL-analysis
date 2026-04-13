import java.util.HashMap;
import java.util.Map;

public class java_19304_SessionManager_A03 {
    private Map<String, String> sessionMap;

    // A constructor is not necessary in this case, but it's a good practice to include one
    public java_19304_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get a user from a session
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}