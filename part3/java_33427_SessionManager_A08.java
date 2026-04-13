import java.util.HashMap;

public class java_33427_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_33427_SessionManager_A08() {
        sessions = new HashMap<String, Session>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void createSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public void updateSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

class Session {
    private String id;

    public java_33427_SessionManager_A08(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}