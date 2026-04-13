import java.util.HashMap;
import java.util.Map;

public class java_06403_SessionManager_A01 {
    // SessionStorage to hold all sessions
    private Map<String, String> sessionStorage;

    public java_06403_SessionManager_A01() {
        sessionStorage = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }
        sessionStorage.put(sessionId, "Active");
        return sessionId;
    }

    // Method to terminate an existing session
    public void terminateSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }
        sessionStorage.remove(sessionId);
    }

    // Method to retrieve the current status of a session
    public String getSessionStatus(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }
        return sessionStorage.get(sessionId);
    }

    // Example usage:
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String sessionId = sm.createSession("session1");
        System.out.println("Created session: " + sessionId);
        System.out.println("Session status: " + sm.getSessionStatus(sessionId));
        sm.terminateSession(sessionId);
        System.out.println("Session status after termination: " + sm.getSessionStatus(sessionId));
    }
}