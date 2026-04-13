import java.util.HashMap;
import java.util.Map;

public class java_16857_SessionManager_A03 {
    // In-memory database to store session objects
    private Map<String, Session> sessions;

    public java_16857_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    // Method to save a session
    public void saveSession(Session session) {
        sessions.put(session.getId(), session);
    }

    // Method to retrieve a session
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Session class
    public class Session {
        private String id;
        private Object data;

        public java_16857_SessionManager_A03(String id) {
            this.id = id;
            this.data = new Object(); // Default data
        }

        public String getId() {
            return id;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}