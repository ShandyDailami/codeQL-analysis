import java.util.HashMap;

public class java_06823_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_06823_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        Session session = new Session(username);
        String sessionId = session.getId();
        sessions.put(sessionId, session);
        return sessionId;
    }

    public String getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null && session.isValid()) {
            return session.getUsername();
        } else {
            return "Invalid session";
        }
    }

    public void invalidateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.invalidate();
        }
    }
}

class Session {
    private String username;
    private boolean valid;

    public java_06823_SessionManager_A01(String username) {
        this.username = username;
        this.valid = true;
    }

    public String getId() {
        return this.username;
    }

    public String getUsername() {
        return this.username;
    }

    public void invalidate() {
        this.valid = false;
    }

    public boolean isValid() {
        return this.valid;
    }
}