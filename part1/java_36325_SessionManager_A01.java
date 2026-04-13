import java.util.HashSet;
import java.util.Set;

public class java_36325_SessionManager_A01 {
    private Set<Session> sessions;

    public java_36325_SessionManager_A01() {
        this.sessions = new HashSet<>();
    }

    public void addSession(Session session) {
        this.sessions.add(session);
    }

    public void removeSession(Session session) {
        this.sessions.remove(session);
    }

    public Set<Session> getSessions() {
        return this.sessions;
    }
}

class Session {
    private String id;

    public java_36325_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}