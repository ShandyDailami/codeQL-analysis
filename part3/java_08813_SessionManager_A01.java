import java.util.HashMap;
import java.util.Map;

public class java_08813_SessionManager_A01 {
    // A Map to simulate a Database
    private Map<String, String> userDatabase = new HashMap<>();

    // A Map to store sessions
    private Map<String, String> sessionMap = new HashMap<>();

    // Constructor
    public java_08813_SessionManager_A01() {
        // Populate the userDatabase with some dummy data
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    // Method to authenticate a user
    public boolean authenticate(String user, String password) {
        // Check if the password is correct
        if (userDatabase.containsKey(user) && userDatabase.get(user).equals(password)) {
            // Create a session for the user
            String sessionId = createSession(user);

            // Return true and store the session id
            return true;
        }

        // Return false
        return false;
    }

    // Method to create a session
    private String createSession(String user) {
        // Generate a session id
        String sessionId = "session_" + user;

        // Store the session id in the session map
        sessionMap.put(sessionId, user);

        // Return the session id
        return sessionId;
    }

    // Method to get the user from a session
    public String getUserFromSession(String sessionId) {
        // Check if the session id is in the session map
        if (sessionMap.containsKey(sessionId)) {
            // Get the user from the session map
            String user = sessionMap.get(sessionId);

            // Return the user
            return user;
        }

        // Return null if the session id is not in the session map
        return null;
    }
}