import java.util.HashMap;
import java.util.Map;

public class java_37656_SessionManager_A01 {
    // Define a HashMap to hold the sessions.
    private Map<String, Session> sessions;

    // Initialize the sessions map.
    public java_37656_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Define a session class.
    public class Session {
        private String id;
        private Object data;

        // Define session constructor.
        public java_37656_SessionManager_A01(String id, Object data) {
            this.id = id;
            this.data = data;
        }

        // Getters and setters.
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    // Define a method to create a new session.
    public Session createSession(String id, Object data) {
        Session session = new Session(id, data);
        sessions.put(id, session);
        return session;
    }

    // Define a method to get a session.
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Define a method to remove a session.
    public void removeSession(String id) {
        sessions.remove(id);
    }

    // Define a method to clear all sessions.
    public void clearAllSessions() {
        sessions.clear();
    }

    // Define a method to check if a session exists.
    public boolean hasSession(String id) {
        return sessions.containsKey(id);
    }
}