import java.util.HashMap;
import java.util.Map;

public class java_04442_SessionManager_A07 {

    // A map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_04442_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to authenticate a user
    public String authenticate(String username, String password) {
        // Here you would typically connect to a database
        // and compare the password hashes
        // This is a simplification and is not recommended

        // For now we'll just check the username and password
        if (username.equals("admin") && password.equals("password")) {
            return "admin";
        }
        return null;
    }

    // Method to create a session
    public String createSession(String username) {
        // Generate a unique session ID
        String sessionID = username + System.currentTimeMillis();

        // Store the session ID in the map
        sessionMap.put(sessionID, username);

        // Return the session ID
        return sessionID;
    }

    // Method to get the username of a session
    public String getUsername(String sessionID) {
        // Retrieve the username from the map
        return sessionMap.get(sessionID);
    }

    // Method to destroy a session
    public void destroySession(String sessionID) {
        // Remove the session ID from the map
        sessionMap.remove(sessionID);
    }
}