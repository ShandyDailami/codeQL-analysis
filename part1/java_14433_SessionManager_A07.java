import java.util.HashMap;

public class java_14433_SessionManager_A07 {

    // HashMap to store session details
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_14433_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to add a new session
    public void addSession(String sessionId, String userId) {
        this.sessionMap.put(sessionId, userId);
    }

    // Method to check if the session is valid
    public String isValidSession(String sessionId) {
        return this.sessionMap.getOrDefault(sessionId, null);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }

    // Method to update userId of a session
    public void updateSession(String sessionId, String userId) {
        if(this.sessionMap.containsKey(sessionId)) {
            this.sessionMap.put(sessionId, userId);
        }
    }
}