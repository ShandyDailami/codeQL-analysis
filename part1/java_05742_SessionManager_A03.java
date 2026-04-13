import java.util.HashMap;

public class java_05742_SessionManager_A03 {
    private HashMap<String, Session> sessions;

    public java_05742_SessionManager_A03() {
        sessions = new HashMap<String, Session>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
        }
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}

class Session {
    private String id;

    public java_05742_SessionManager_A03(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        // This operation is security-sensitive and it's not a part of the original problem.
        // In a real-world application, it's not just about setting the ID, but also performing checks and validations.
    }
}