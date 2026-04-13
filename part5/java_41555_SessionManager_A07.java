import java.util.HashMap;

public class java_41555_SessionManager_A07 {
    // We use a HashMap to simulate the storage of sessions.
    private HashMap<String, Session> sessions;

    public java_41555_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // A session represents a user's interaction with the application.
    public class Session {
        private String user;

        public java_41555_SessionManager_A07(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }

    // Method to create a new session for a user.
    public Session createSession(String user) {
        Session session = new Session(user);
        sessions.put(user, session);
        return session;
    }

    // Method to get a session for a user.
    public Session getSession(String user) throws AuthFailure {
        if (!sessions.containsKey(user)) {
            throw new AuthFailure("User not found");
        }
        return sessions.get(user);
    }

    // Method to delete a session for a user.
    public void deleteSession(String user) {
        sessions.remove(user);
    }
}