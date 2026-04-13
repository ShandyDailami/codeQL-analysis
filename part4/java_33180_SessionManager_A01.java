import java.util.ArrayList;
import java.util.List;

public class java_33180_SessionManager_A01 {
    private List<Session> sessions;

    public java_33180_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public Session getSession(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }

    public boolean validateSession(String sessionId, String password) {
        Session session = getSession(sessionId);
        if (session == null) {
            return false;
        }
        return session.getPassword().equals(password);
    }
}

class Session {
    private String id;
    private String password;

    public java_33180_SessionManager_A01(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}