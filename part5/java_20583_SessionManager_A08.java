import java.util.HashMap;

public class java_20583_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_20583_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists!");
        } else {
            sessionMap.put(sessionId, sessionId);
            return sessionId;
        }
    }

    // Method to remove a session
    public String removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.remove(sessionId);
        } else {
            throw new IllegalStateException("No such session exists!");
        }
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }
}