import java.util.HashMap;

public class java_18603_SessionManager_A07 {
    // A simple in-memory storage for sessions
    private HashMap<String, String> sessionStorage = new HashMap<>();

    // The constructor
    public java_18603_SessionManager_A07() {
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionStorage.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionStorage.containsKey(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }

    // Method to get the session data
    public String getSessionData(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new SecurityFailureException("Invalid session id");
        }
        return sessionStorage.get(sessionId);
    }
}