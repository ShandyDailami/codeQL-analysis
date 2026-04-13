import java.util.HashMap;
import java.util.Random;

public class java_34959_SessionManager_A08 {
    private HashMap<String, Session> sessions;
    private Random random;

    public java_34959_SessionManager_A08() {
        this.sessions = new HashMap<>();
        this.random = new Random();
    }

    public String createSession(User user) {
        String sessionId = generateSessionId();
        Session session = new Session(user, sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public User getUserFromSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            Session session = sessions.get(sessionId);
            return session.getUser();
        } else {
            // Session not found or integrity failure
            // Handle this case here.
            return null;
        }
    }

    public boolean destroySession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return true;
        } else {
            // Session not found or integrity failure
            // Handle this case here.
            return false;
        }
    }

    private String generateSessionId() {
        return String.valueOf(random.nextLong());
    }

    // Session class for handling user and session id.
    // The session class could be more complex, depending on your requirements.
    private class Session {
        private User user;
        private String sessionId;

        public java_34959_SessionManager_A08(User user, String sessionId) {
            this.user = user;
            this.sessionId = sessionId;
        }

        public User getUser() {
            return user;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}

// User class for handling user information.
class User {
    private String name;

    public java_34959_SessionManager_A08(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}