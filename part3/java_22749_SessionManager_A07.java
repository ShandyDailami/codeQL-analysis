import java.util.HashMap;

public class java_22749_SessionManager_A07 {
    // Create a HashMap to store user sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_22749_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        // Simulate a successful authentication
        // Here we are checking if username and password match
        // In real world, these should come from a secure source like a database
        return username.equals("admin") && password.equals("password");
    }

    // Method to create a session for a user
    public String createSession(String username) {
        // Generate a unique session ID
        String sessionId = java.util.UUID.randomUUID().toString();

        // Store the session ID and username in the session map
        sessionMap.put(sessionId, username);

        // Return the session ID
        return sessionId;
    }

    // Method to get the username for a given session ID
    public String getUsernameForSession(String sessionId) {
        // Check if the session ID is in the session map
        if (sessionMap.containsKey(sessionId)) {
            // Return the username associated with the session ID
            return sessionMap.get(sessionId);
        } else {
            // Return null if the session ID is not in the map
            return null;
        }
    }

    // Method to remove a session from the session map
    public void removeSession(String sessionId) {
        // Remove the session ID and username from the session map
        sessionMap.remove(sessionId);
    }
}