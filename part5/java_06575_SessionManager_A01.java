public class java_06575_SessionManager_A01 {
    private String sessionId;

    public java_06575_SessionManager_A01(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

public class SessionManager {
    private Map<String, Session> sessions;

    public java_06575_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        this.sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return this.sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        this.sessions.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a new session
        Session newSession = sessionManager.createSession("session1");
        System.out.println("Created session with ID: " + newSession.getSessionId());

        // Get a session
        Session session = sessionManager.getSession("session1");
        System.out.println("Retrieved session with ID: " + session.getSessionId());

        // Destroy a session
        sessionManager.destroySession("session1");
        System.out.println("Destroyed session with ID: " + session.getSessionId());
    }
}