import java.util.ArrayList;
import java.util.List;

public class java_03750_SessionManager_A01 {
    private List<Session> sessions;

    public java_03750_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        if (session != null) {
            sessions.add(session);
        }
    }

    public void closeSession(Session session) {
        if (session != null) {
            sessions.remove(session);
        }
    }
}

public class Session {
    private String id;

    public java_03750_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = new Session("session1");
        Session session2 = new Session("session2");

        sessionManager.addSession(session1);
        sessionManager.addSession(session2);

        // Try to close session2
        sessionManager.closeSession(session2);
    }
}