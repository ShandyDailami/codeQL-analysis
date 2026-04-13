import java.util.HashMap;

public class java_09639_SessionManager_A07 {
    // Create a private HashMap to store session data.
    private HashMap<String, String> sessionData = new HashMap<>();

    // This method is used to create a session.
    public String createSession(String user) {
        // Generate a unique session id.
        String sessionId = user + System.currentTimeMillis();

        // Store the session id and user name in the HashMap.
        sessionData.put(sessionId, user);

        // Return the session id.
        return sessionId;
    }

    // This method is used to validate a session.
    public String validateSession(String sessionId) {
        // Check if the sessionId is present in the HashMap.
        if (sessionData.containsKey(sessionId)) {
            // Return the user name associated with the session id.
            return sessionData.get(sessionId);
        } else {
            // Return null if the sessionId is not present in the HashMap.
            return null;
        }
    }

    // This method is used to invalidate a session.
    public void invalidateSession(String sessionId) {
        // Remove the session id from the HashMap.
        sessionData.remove(sessionId);
    }
}