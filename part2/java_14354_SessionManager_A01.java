import java.util.HashMap;

public class java_14354_SessionManager_A01 {
    // Create a new HashMap to store sessions.
    private HashMap<String, String> sessionMap = new HashMap<>();

    // This method adds a session.
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // This method removes a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This method checks if a session is valid.
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // This method returns the user ID of a session.
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }
}