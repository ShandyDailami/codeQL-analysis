import java.util.ArrayList;
import java.util.List;

public class java_13566_SessionManager_A01 {
    private List<Session> sessions;

    public java_13566_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public void createSession() {
        Session session = new Session();
        sessions.add(session);
    }

    public Session getSession(int index) {
        if (index < 0 || index >= sessions.size()) {
            throw new IllegalArgumentException("Invalid session index");
        }
        return sessions.get(index);
    }

    public void closeSession(int index) {
        if (index < 0 || index >= sessions.size()) {
            throw new IllegalArgumentException("Invalid session index");
        }
        sessions.remove(index);
    }

    private class Session {
        // Just a placeholder for now
    }
}