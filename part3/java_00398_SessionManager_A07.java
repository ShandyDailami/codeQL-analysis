import java.util.HashMap;

public class java_00398_SessionManager_A07 {
    // Define a HashMap to store sessions
    private HashMap<String, Session> sessions = new HashMap<>();

    // Define a ThreadLocal to manage sessions
    private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>() {
        @Override
        protected Session initialValue() {
            return new Session();
        }
    };

    // Session class
    public class Session {
        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void invalidate() {
            userId = null;
        }
    }

    // Method to get a session
    public Session getSession(String sessionId) throws AuthFailure {
        Session session = sessions.get(sessionId);

        if (session == null) {
            throw new AuthFailure("Session not found: " + sessionId);
        }

        return session;
    }

    // Method to create a session
    public Session createSession(String userId) {
        Session session = sessionThreadLocal.get();
        session.setUserId(userId);
        sessions.put(session.getUserId(), session);

        return session;
    }

    // Method to invalidate a session
    public void invalidateSession(String userId) {
        Session session = sessions.get(userId);

        if (session != null) {
            session.invalidate();
        }
    }
}

// Exception class for authentication failure
public class AuthFailure extends Exception {
    public java_00398_SessionManager_A07(String message) {
        super(message);
    }
}