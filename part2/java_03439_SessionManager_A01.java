public class java_03439_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_03439_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public Session getSession(String username) {
        // Create a new session if one does not exist already
        Session session = sessions.get(username);
        if (session == null) {
            session = new Session(username);
            sessions.put(username, session);
        }
        return session;
    }

    public void closeSession(String username) {
        // Remove the session from the map if it exists
        sessions.remove(username);
    }
}

public class Session {
    private String username;
    private boolean isClosed;

    public java_03439_SessionManager_A01(String username) {
        this.username = username;
        this.isClosed = false;
    }

    public void close() {
        // Simulate closing a session, which would also invalidate the session
        this.isClosed = true;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isClosed() {
        return this.isClosed;
    }
}