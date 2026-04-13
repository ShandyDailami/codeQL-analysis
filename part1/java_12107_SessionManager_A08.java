import java.util.HashMap;
import java.util.Map;

public class java_12107_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_12107_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session openSession() {
        String sessionId = generateSessionId();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
       
        }
    }

    private String generateSessionId() {
        // This is a simple way to generate a random session id.
        // In a real application, you would probably use UUID or some other unique identifier.
        return String.valueOf(System.currentTimeMillis());
    }
}

class Session {
    private String id;

    public java_12107_SessionManager_A08(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}