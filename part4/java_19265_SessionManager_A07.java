import java.util.HashMap;

public class java_19265_SessionManager_A07 {
    // A HashMap to simulate the database.
    // In a real world scenario, you would connect to a database using JDBC.
    private HashMap<String, String> sessionMap = new HashMap<>();

    // Method to create a session.
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID.
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId); // Return the username.
        } else {
            return null; // Return null if the session is invalid.
        }
    }

    // Method to end a session.
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}