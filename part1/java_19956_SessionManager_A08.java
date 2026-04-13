import java.util.HashMap;

public class java_19956_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_19956_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

class Session {
    private String id;

    public java_19956_SessionManager_A08(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}