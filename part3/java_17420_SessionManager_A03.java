import java.util.HashMap;

public class java_17420_SessionManager_A03 {

    // Using HashMap for session storage
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_17420_SessionManager_A03() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to add session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to remove session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get userId for given sessionId
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }
}