import java.util.HashMap;
import java.util.Map;

public class java_21569_SessionManager_A03 {
    // Using a Map to store sessions.
    private Map<String, String> sessions;

    // Initializing the map.
    public java_21569_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String username) {
        // Generating a unique session ID.
        String sessionID = String.valueOf(System.currentTimeMillis());

        // Storing the session ID and username.
        this.sessions.put(sessionID, username);

        // Returning the session ID.
        return sessionID;
    }

    // Method to get the username from a session.
    public String getUsername(String sessionID) {
        // Returning the username associated with the session ID.
        return this.sessions.get(sessionID);
    }

    // Method to close a session.
    public void closeSession(String sessionID) {
        // Removing the session from the map.
        this.sessions.remove(sessionID);
    }
}