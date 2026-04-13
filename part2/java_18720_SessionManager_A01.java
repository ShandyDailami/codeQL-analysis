import java.util.ArrayList;
import java.util.List;

public class java_18720_SessionManager_A01 {
    private List<Session> sessions;

    public java_18720_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public Session getSession(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }
}

public class Session {
    private String id;

    public java_18720_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        Session session1 = new Session("session1");
        Session session2 = new Session("session2");

        manager.addSession(session1);
        manager.addSession(session2);

        Session sessionFromManager = manager.getSession("session1");
        if (sessionFromManager == null) {
            System.out.println("No session found with id 'session1'");
        } else {
            System.out.println("Found session with id " + sessionFromManager.getId());
        }

        manager.removeSession(session2);

        sessionFromManager = manager.getSession("session1");
        if (sessionFromManager == null) {
            System.out.println("No session found with id 'session1'");
        } else {
            System.out.println("Found session with id " + sessionFromManager.getId());
        }
    }
}