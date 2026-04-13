import java.util.HashMap;

public class java_14481_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_14481_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String getSession(String username) {
        // A07_AuthFailure: Check if user is authenticated.
        if (username == null || username.isEmpty()) {
            throw new A07_AuthFailure("User not authenticated");
        }

        // Create and return session ID
        String sessionID = generateSessionID(username);
        sessions.put(sessionID, username);
        return sessionID;
    }

    public String getUser(String sessionID) {
        // A07_AuthFailure: Check if session is valid.
        if (sessionID == null || sessionID.isEmpty()) {
            throw new A07_AuthFailure("Session not valid");
        }

        // Return username from session
        return sessions.get(sessionID);
    }

    private String generateSessionID(String username) {
        // A07_AuthFailure: Generate a unique session ID.
        return "SESSION_" + username;
    }
}