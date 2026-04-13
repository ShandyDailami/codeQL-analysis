import java.util.HashMap;
import java.util.Map;

public class java_18918_SessionManager_A07 {
    // A session is represented as a combination of username and password
    private static class Session {
        String username;
        String password;
    }

    // A map to store sessions
    private Map<String, Session> sessions;

    public java_18918_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username, String password) {
        // Create a new session
        Session session = new Session();
        session.username = username;
        session.password = password;

        // Generate a session ID using a simple random generation
        String sessionID = String.valueOf(Math.random() * 1000000);

        // Store the session in the map
        sessions.put(sessionID, session);

        // Return the session ID
        return sessionID;
    }

    // Method to check if a session exists
    public boolean sessionExists(String sessionID) {
        // Check if the session ID exists in the map
        return sessions.containsKey(sessionID);
    }

    // Method to get the session associated with a session ID
    public Session getSession(String sessionID) {
        // Get the session from the map
        return sessions.get(sessionID);
    }

    // Method to delete a session
    public void deleteSession(String sessionID) {
        // Delete the session from the map
        sessions.remove(sessionID);
    }
}