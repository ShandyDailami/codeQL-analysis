import java.util.HashMap;
import java.util.Map;

public class java_40923_SessionManager_A01 {

    // Create a HashMap to store session ids and session objects.
    private Map<String, Session> sessionMap;

    public java_40923_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(Session session) {
        String sessionId = session.getId();
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    // Method to retrieve a session based on session id.
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session based on session id.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

class Session {
    private String id;

    public java_40923_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}