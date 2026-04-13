import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_33496_SessionManager_A01 {

    // A ConcurrentHashMap is used to store sessions
    private Map<String, Session> sessions;

    // Constructor to initialize the sessions map
    public java_33496_SessionManager_A01() {
        sessions = new ConcurrentHashMap<>();
    }

    // Method to add a session
    public void addSession(Session session) {
        sessions.put(session.getId(), session);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }
}

// Session class is left as an example
class Session {
    private String id;

    // Constructor
    public java_33496_SessionManager_A01(String id) {
        this.id = id;
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
        this.id = id;
    }
}