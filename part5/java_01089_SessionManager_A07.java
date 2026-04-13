import java.util.HashMap;
import java.util.Map;

public class java_01089_SessionManager_A07 {

    // A map to hold session data. 
    private Map<String, String> sessionMap;

    // Constructor to initialize sessionMap.
    public java_01089_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to add a session.
    public void addSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    // Method to get a session.
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to clear all sessions.
    public void clearAllSessions() {
        sessionMap.clear();
    }

    // Method to check if a session is valid.
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // A simple example of a security-sensitive operation.
    public void authenticateUser(String sessionId, String userName) {
        if (!isValidSession(sessionId)) {
            throw new AuthFailureException("Invalid session Id");
        }

        if (!sessionMap.get(sessionId).equals(userName)) {
            throw new AuthFailureException("Invalid username");
        }
    }

    // A class that throws an exception when called.
    public static class AuthFailureException extends RuntimeException {
        public java_01089_SessionManager_A07(String message) {
            super(message);
        }
    }
}