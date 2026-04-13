import java.util.HashMap;
import java.util.Map;

public class java_36507_SessionManager_A03 implements SessionManager {
    private Map<String, Session> sessions;

    public java_36507_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    @Override
    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new SecureSession(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    @Override
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session with id " + sessionId + " not found");
        }
        return session;
    }

    @Override
    public void destroySession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session with id " + sessionId + " not found");
        }
        sessions.remove(sessionId);
    }
}

interface SessionManager {
    Session createSession();
    Session getSession(String sessionId);
    void destroySession(String sessionId);
}

class SecureSession implements Session {
    private String id;

    public java_36507_SessionManager_A03(String id) {
        this.id = id;
    }

    // Implement methods from Session interface here

    @Override
    public String getId() {
        return id;
    }
}

interface Session {
    String getId();
    // Implement methods from Session interface here
}

class SessionNotFoundException extends RuntimeException {
    public java_36507_SessionManager_A03(String message) {
        super(message);
    }
}