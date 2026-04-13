import java.util.HashMap;
import java.util.Map;

public class java_29929_SessionManager_A07 {
    // A map to store sessions
    private Map<String, Session> sessionMap;

    public java_29929_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Object user) {
        // Create a new session
        Session session = new Session(user);

        // Add the session to the map
        sessionMap.put(session.getId(), session);

        return session.getId();
    }

    public Object getSession(String sessionId) {
        // Get the session from the map
        Session session = sessionMap.get(sessionId);

        return session == null ? null : session.getUser();
    }

    public void destroySession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }

    public class Session {
        private String id;
        private Object user;

        public java_29929_SessionManager_A07(Object user) {
            this.user = user;
            this.id = UUID.randomUUID().toString(); // Generate a unique ID
        }

        public String getId() {
            return id;
        }

        public Object getUser() {
            return user;
        }
    }
}