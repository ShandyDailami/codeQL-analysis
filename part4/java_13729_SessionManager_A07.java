import java.util.HashMap;
import java.util.Map;

public class java_13729_SessionManager_A07 {

    // Create a HashMap to store the userID and Session objects
    private Map<Integer, Session> sessionMap;

    // The next session ID to use
    private int nextSessionId = 1;

    // Create a SessionManager
    public java_13729_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Create a new session
    public Session createSession(User user) {
        Session session = new Session(nextSessionId, user);
        sessionMap.put(nextSessionId, session);
        nextSessionId++;
        return session;
    }

    // Get a session
    public Session getSession(int sessionId) throws SessionNotFoundException {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session not found with id: " + sessionId);
        }
        return session;
    }

    // Check if a session exists
    public boolean hasSession(int sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Destroy a session
    public void destroySession(int sessionId) throws SessionNotFoundException {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session not found with id: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    // Inner Session class
    public class Session {

        private int id;
        private User user;

        public java_13729_SessionManager_A07(int id, User user) {
            this.id = id;
            this.user = user;
        }

        public int getId() {
            return id;
        }

        public User getUser() {
            return user;
        }

        // Security sensitive operation related to A07_AuthFailure
        public void invalidateSession() {
            // Add code here to invalidate the session and remove the user from the system
        }
    }

    // Inner User class
    public class User {

        private int id;
        private String name;

        public java_13729_SessionManager_A07(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    // Inner SessionNotFoundException class
    public class SessionNotFoundException extends Exception {
        public java_13729_SessionManager_A07(String message) {
            super(message);
        }
    }
}