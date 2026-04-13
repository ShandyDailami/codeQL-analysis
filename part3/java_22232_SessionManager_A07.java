import java.util.HashMap;
import java.util.Map;

public class java_22232_SessionManager_A07 {
    // Create a Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_22232_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        // Create a session identifier by hashing the user name
        String sessionId = user.hashCode() + "";
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user from the session
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("Alice");
        System.out.println("Session created: " + sessionId);

        // Get the user from the session
        String user = sessionManager.getUserFromSession(sessionId);
        System.out.println("User from session: " + user);

        // Remove the session
        sessionManager.removeSession(sessionId);
        System.out.println("Session removed: " + sessionId);

        // Check if the session exists
        System.out.println("Does session exist? " + sessionManager.sessionExists(sessionId));
    }
}