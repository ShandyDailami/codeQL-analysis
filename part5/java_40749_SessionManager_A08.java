import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_40749_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_40749_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        String sessionId = UUID.randomUUID().toString();
        session.setId(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session validateSession(String sessionId) throws SecurityException {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new SecurityException("Invalid Session ID: " + sessionId);
        }
        return session;
    }

    public void handleSessionError(String sessionId, Exception e) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            System.out.println("Error: Invalid Session ID. No such session found.");
            return;
        }
        System.out.println("Error: Session " + sessionId + " encountered an error: " + e.getMessage());
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