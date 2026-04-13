import java.util.HashMap;

public class java_21141_SessionManager_A01 {
    // private HashMap to store session data
    private HashMap<String, String> sessionData;

    // Constructor
    public java_21141_SessionManager_A01() {
        this.sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionData.put(sessionId, user);
        return sessionId;
    }

    // Method to retrieve a session
    public String getSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Method to terminate a session
    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}