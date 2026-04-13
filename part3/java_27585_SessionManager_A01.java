import java.util.HashMap;
import java.util.Map;

public class java_27585_SessionManager_A01 {
    // Create a thread-safe HashMap to store sessions
    private Map<String, Session> sessions = new ConcurrentHashMap<>();

    // Session class
    public class Session {
        private String id;
        private Object data;

        public java_27585_SessionManager_A01(String id, Object data) {
            this.id = id;
            this.data = data;
        }

        public String getId() {
            return id;
        }

        public Object getData() {
            return data;
        }
    }

    // Method to create a new session
    public Session createSession(String id, Object data) {
        return new Session(id, data);
    }

    // Method to retrieve session data
    public Object getSessionData(String id) {
        Session session = sessions.get(id);
        if (session == null) {
            throw new IllegalArgumentException("No session found with id " + id);
        }
        return session.getData();
    }

    // Method to update session data
    public void updateSessionData(String id, Object data) {
        Session session = sessions.get(id);
        if (session == null) {
            throw new IllegalArgumentException("No session found with id " + id);
        }
        session.data = data;
    }
}