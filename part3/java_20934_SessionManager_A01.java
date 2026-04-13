import java.util.HashMap;
import java.util.Map;

public class java_20934_SessionManager_A01 {
    // Create a HashMap to store the sessions.
    private Map<String, String> sessionMap;

    // Initialize the session map.
    public java_20934_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username for a given session id.
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to check if a session id is valid.
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Demonstrate the session manager.
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("Alice");
        System.out.println("Session created with ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username for session ID " + sessionId + ": " + username);

        boolean isValid = sessionManager.isValidSession(sessionId);
        System.out.println("Is valid session ID " + sessionId + ": " + isValid);

        sessionManager.removeSession(sessionId);
        isValid = sessionManager.isValidSession(sessionId);
        System.out.println("Is valid session ID " + sessionId + " after removal: " + isValid);
    }
}