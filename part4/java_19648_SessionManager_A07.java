import java.util.HashMap;
import java.util.Map;

public class java_19648_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_19648_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists.");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session with id " + sessionId + " exists.");
        }
        return session;
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}

class Session {
    private String id;

    public java_19648_SessionManager_A07(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.createSession("session1");
        Session session2 = sessionManager.createSession("session2");

        // Accessing existing sessions
        System.out.println("Session 1 id: " + session1.getId());
        System.out.println("Session 2 id: " + session2.getId());

        // Destroying a session
        sessionManager.destroySession("session1");

        // Attempting to access a session that no longer exists
        try {
            System.out.println("Trying to access a non-existent session...");
            Session nonExistentSession = sessionManager.getSession("session1");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}