import java.util.HashMap;

public class java_12930_SessionManager_A03 {

    // Private instance of HashMap to store session information
    private HashMap<String, String> sessionMap;

    // Constructor to initialize HashMap
    public java_12930_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to add session information
    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    // Method to get session information
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove session information
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}