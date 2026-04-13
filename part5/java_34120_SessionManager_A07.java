import java.util.HashMap;
import java.util.UUID;

public class java_34120_SessionManager_A07 {
    private HashMap<String, Session> sessions;

    public java_34120_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean validateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            return false;
        }
        return true;
    }

    public String createToken(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            return null;
        }
        String token = UUID.randomUUID().toString();
        session.setToken(token);
        return token;
    }

    public boolean validateToken(String sessionId, String token) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            return false;
        }
        if (!session.getToken().equals(token)) {
            return false;
        }
        return true;
    }
}

class Session {
    private String sessionId;
    private String token;

    public java_34120_SessionManager_A07(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getSessionId() {
        return sessionId;
    }
}