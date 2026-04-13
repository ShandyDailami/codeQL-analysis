import java.util.HashMap;

public class java_01087_SessionManager_A01 {
    // Create a HashMap to store sessions.
    private HashMap<String, String> sessionMap = new HashMap<>();

    // Save a session.
    public void saveSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    // Get a session.
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}