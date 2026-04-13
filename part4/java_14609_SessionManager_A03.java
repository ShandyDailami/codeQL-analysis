import java.util.HashMap;

public class java_14609_SessionManager_A03 {

    // Define a HashMap to store session data.
    private HashMap<String, String> sessionData;

    // Initialize the session data.
    public java_14609_SessionManager_A03() {
        this.sessionData = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String sessionId) {
        this.sessionData.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to validate if a session exists.
    public String validateSession(String sessionId) {
        return this.sessionData.get(sessionId);
    }

    // Method to invalidate a session.
    public void invalidateSession(String sessionId) {
        this.sessionData.remove(sessionId);
    }
}