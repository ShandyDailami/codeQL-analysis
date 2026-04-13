import java.util.HashMap;
import java.util.Map;

public class java_38843_SessionManager_A01 {

    // Define a map to store the sessions
    private Map<String, String> sessionMap;

    public java_38843_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        String sessionId = java.util.UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username for a given session
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session for user "Alice"
        String sessionId1 = sessionManager.createSession("Alice");

        // Retrieve the username for the session
        String username = sessionManager.getUsername(sessionId1);
        System.out.println("Username: " + username); // Outputs: Username: Alice

        // Try to retrieve the username for a non-existent session
        String username2 = sessionManager.getUsername("Non-existentSession");
        System.out.println("Username (should be null): " + username2); // Outputs: Username (should be null): null

        // Delete the session
        sessionManager.deleteSession(sessionId1);

        // Try to retrieve the username after deleting a session
        String username3 = sessionManager.getUsername("Non-existentSession");
        System.out.println("Username (should be null): " + username3); // Outputs: Username (should be null): null
    }
}