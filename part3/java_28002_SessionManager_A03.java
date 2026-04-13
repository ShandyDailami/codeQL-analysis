import java.util.HashMap;
import java.util.Map;

public class java_28002_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_28002_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with ID: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session found with ID: " + sessionId);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        Session session = sessions.remove(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session to destroy with ID: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Session session1 = sessionManager.createSession("session1");
        Session session2 = sessionManager.createSession("session2");

        session1.setAttribute("attribute1", "value1");
        session2.setAttribute("attribute2", "value2");

        sessionManager.getSession("session1"); // get the session
        sessionManager.destroySession("session1"); // destroy the session

        sessionManager.getSession("session1"); // should throw an exception
        sessionManager.destroySession("session1"); // should throw an exception
    }
}