import java.util.HashMap;

public class java_37118_SessionManager_A03 {

    private HashMap<String, Object> sessionMap;

    public java_37118_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Object sessionObject) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, sessionObject);
        return sessionId;
    }

    // Method to retrieve a session
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive method to check if a session exists
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}