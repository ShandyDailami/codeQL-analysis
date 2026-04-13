import java.util.HashMap;
import java.util.Map;

public class java_25365_SessionManager_A03 {
    // A map to hold the sessions
    private Map<String, Session> sessions;

    public java_25365_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to open a session
    public Session openSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
            return null;
        }

        Session session = new Session();
        session.setId(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("No session with id: " + sessionId);
            return;
        }

        sessions.remove(sessionId);
    }
}

class Session {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}