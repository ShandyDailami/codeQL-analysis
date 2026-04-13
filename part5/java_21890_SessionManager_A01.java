import java.util.HashMap;
import java.util.Map;

public class java_21890_SessionManager_A01 {
    private Map<String, Session> sessionMap;

    public java_21890_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessionMap.put(session.getId(), session);
        return session;
    }

    public Session getSession(String id) {
        return sessionMap.get(id);
    }

    public void invalidateSession(String id) {
        Session session = sessionMap.get(id);
        if (session != null) {
            session.setValid(false);
        }
    }
}

class Session {
    private boolean valid;
    private String id;

    public java_21890_SessionManager_A01() {
        this.id = UUID.randomUUID().toString(); // Generate a random UUID for the session ID
        this.valid = true;
    }

    public String getId() {
        return id;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }
}