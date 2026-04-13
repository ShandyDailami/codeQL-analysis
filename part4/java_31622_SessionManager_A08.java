import java.util.HashMap;
import java.util.Map;

public class java_31622_SessionManager_A08 {
    // A map to store sessions
    private Map<String, Session> sessions;

    // The constructor initializes the map
    public java_31622_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to add a session to the map
    public void addSession(Session session) {
        sessions.put(session.getId(), session);
    }

    // Method to remove a session from the map
    public void removeSession(String id) {
        sessions.remove(id);
    }

    // Method to get a session from the map
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // A simple Session class
    public class Session {
        private String id;

        // Constructor to initialize the id
        public java_31622_SessionManager_A08(String id) {
            this.id = id;
        }

        // Getter for the id
        public String getId() {
            return id;
        }

        // Setter for the id
        public void setId(String id) {
            this.id = id;
        }
    }
}