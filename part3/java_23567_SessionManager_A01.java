import java.util.HashMap;

public class java_23567_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_23567_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}