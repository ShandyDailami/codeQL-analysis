import java.util.*;

public class java_31694_SessionManager_A01 {
    private Map<String, UserSession> sessions;

    public java_31694_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
            return;
        }
        sessions.put(sessionId, new UserSession(sessionId));
    }

    public void endSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("No session exists with id: " + sessionId);
            return;
        }
        sessions.remove(sessionId);
    }

    public void accessResource(String sessionId, String resource) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("No session exists with id: " + sessionId);
            return;
        }
        UserSession session = sessions.get(sessionId);
        session.access(resource);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.createSession("s1");
        sm.createSession("s2");

        sm.accessResource("s1", "res1");
        sm.accessResource("s2", "res2");

        sm.endSession("s1");
        sm.endSession("s2");
    }
}

class UserSession {
    private String sessionId;
    private Set<String> resources;

    public java_31694_SessionManager_A01(String sessionId) {
        this.sessionId = sessionId;
        this.resources = new HashSet<>();
    }

    public void access(String resource) {
        resources.add(resource);
        System.out.println("Accessing resource: " + resource + " in session: " + sessionId);
    }
}