import java.util.HashMap;

public class java_32255_SessionManager_A03 {
    // Create a static HashMap for storing sessions
    private static HashMap<String, String> sessionMap = new HashMap<>();

    // Generate a session ID
    private static String generateSessionID() {
        // This is just a simple way to generate a session ID. In a real-world application, you would likely use UUIDs or another method to ensure uniqueness.
        return String.valueOf(System.currentTimeMillis());
    }

    // Create a session
    public String createSession() {
        // Generate a new session ID
        String sessionID = generateSessionID();

        // Store the session ID and start a new session
        sessionMap.put(sessionID, "Session is active");

        // Return the session ID
        return sessionID;
    }

    // Get a session
    public String getSession(String sessionID) {
        // Check if the session ID exists in the map
        if (sessionMap.containsKey(sessionID)) {
            // If it does, return the session information
            return sessionMap.get(sessionID);
        } else {
            // If it doesn't, return a message indicating that the session does not exist
            return "No active session found";
        }
    }

    // End a session
    public void endSession(String sessionID) {
        // Remove the session from the map
        sessionMap.remove(sessionID);
    }
}