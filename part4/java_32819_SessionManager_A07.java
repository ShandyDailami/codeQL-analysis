import java.util.HashMap;

public class java_32819_SessionManager_A07 {

    // Create a HashMap to store session data
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_32819_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get the userId of a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to check if a sessionId exists
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}