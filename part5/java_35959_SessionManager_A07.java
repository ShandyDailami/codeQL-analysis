import java.util.HashMap;

public class java_35959_SessionManager_A07 {
    // This is a HashMap that we will use to store the sessions.
    // The keys in the HashMap are session identifiers, and the values are the actual sessions.
    private HashMap<String, Session> sessions;

    // This is our Session class. A Session has a session identifier and a user identifier.
    public class Session {
        public String sessionId;
        public String userId;
    }

    public java_35959_SessionManager_A07() {
        // Initialize our sessions HashMap.
        sessions = new HashMap<String, Session>();
    }

    // This method adds a new session to our sessions HashMap.
    public void addSession(String sessionId, String userId) {
        // Create a new Session object.
        Session newSession = new Session();
        newSession.sessionId = sessionId;
        newSession.userId = userId;

        // Add the new Session object to our sessions HashMap.
        sessions.put(sessionId, newSession);
    }

    // This method removes a session from our sessions HashMap.
    public void removeSession(String sessionId) {
        // Remove the session from our sessions HashMap.
        sessions.remove(sessionId);
    }

    // This method checks if a session exists in our sessions HashMap.
    public boolean sessionExists(String sessionId) {
        // Check if the session exists in our sessions HashMap.
        return sessions.containsKey(sessionId);
    }

    // This method checks if a user with a certain user identifier exists in our sessions HashMap.
    public boolean userExists(String userId) {
        // Iterate over all the sessions in our sessions HashMap.
        for (Session session : sessions.values()) {
            // If the user identifier in this session matches the user identifier we're looking for,
            // then return true. Otherwise, return false.
            if (session.userId.equals(userId)) {
                return true;
            }
        }
        // If we've made it this far, then no user with this identifier exists in our sessions HashMap.
        return false;
    }
}