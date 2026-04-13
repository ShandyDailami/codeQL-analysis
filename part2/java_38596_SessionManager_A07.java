import java.util.HashMap;

public class java_38596_SessionManager_A07 {
    // Using a HashMap to store session ids and objects
    private HashMap<String, Object> sessionMap = new HashMap<>();

    // Method to create a new session
    public String createSession(Object sessionObject) {
        // Generate a unique session id
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, sessionObject);
        return sessionId;
    }

    // Method to get a session object
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to update a session object
    public void updateSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }
}