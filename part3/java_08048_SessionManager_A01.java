public class java_08048_SessionManager_A01 {
    // This is a simple hash map for demonstration purposes. In a real-world application, you'd use a database or an in-memory data structure.
    private HashMap<String, Session> sessions = new HashMap<String, Session>();

    public java_08048_SessionManager_A01() {
        // Initially, no sessions exist.
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void createSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}

public class Session {
    private String id;

    public java_08048_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}