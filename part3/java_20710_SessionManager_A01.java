import java.util.ArrayList;
import java.util.List;

public class java_20710_SessionManager_A01 {
    private List<Session> sessions;

    public java_20710_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public void removeAllSessions() {
        sessions.clear();
    }

    public List<Session> getSessions() {
        return sessions;
    }
}

public class Session {
    private String id;

    public java_20710_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}