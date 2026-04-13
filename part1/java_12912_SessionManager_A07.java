import java.util.HashMap;

public class java_12912_SessionManager_A07 {
    // Create a HashMap to store sessions.
    private HashMap<String, String> sessions;

    public java_12912_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String username) {
        // Generate a session ID.
        String sessionID = Integer.toString(username.hashCode());
        sessions.put(sessionID, username);
        return sessionID;
    }

    // Method to get the username from a session.
    public String getUsername(String sessionID) {
        return sessions.get(sessionID);
    }

    // Method to check if a session is valid.
    public boolean isValidSession(String sessionID) {
        return sessions.containsKey(sessionID);
    }

    // Method to end a session.
    public void endSession(String sessionID) {
        if (isValidSession(sessionID)) {
            sessions.remove(sessionID);
        }
    }
}