import java.util.HashMap;

public class java_16381_SessionManager_A01 {
    // A map to store sessions, where the key is the session ID and the value is the session object.
    private HashMap<String, Session> sessions = new HashMap<>();

    // A session object represents a user's session.
    public class Session {
        private String user;

        // Constructor to create a new session.
        public java_16381_SessionManager_A01(String user) {
            this.user = user;
        }

        // Getter for the user.
        public String getUser() {
            return user;
        }

        // Setter for the user.
        public void setUser(String user) {
            this.user = user;
        }
    }

    // Create a new session for a user.
    public Session createSession(String user) {
        Session session = new Session(user);
        sessions.put(sessionUserToId(session), session);
        return session;
    }

    // Get a session for a user.
    public Session getSession(String user) {
        return sessions.get(user);
    }

    // Remove a session.
    public void removeSession(Session session) {
        sessions.remove(sessionUserToId(session));
    }

    // Convert a session object to a user ID.
    private String sessionUserToId(Session session) {
        return session.getUser();
    }
}