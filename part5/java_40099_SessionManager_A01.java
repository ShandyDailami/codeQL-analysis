public class java_40099_SessionManager_A01 {
    private static SessionManager instance;
    private java_40099_SessionManager_A01() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private HashMap<String, Session> sessions = new HashMap<>();

    public Session createSession(String id) {
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void deleteSession(String id) {
        sessions.remove(id);
    }
}

public class Session {
    private String id;

    public java_40099_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();

        Session session1 = sessionManager.createSession("session1");
        Session session2 = sessionManager.createSession("session2");

        // Access to session data
        System.out.println(session1.getId());
        System.out.println(session2.getId());

        // Delete session
        sessionManager.deleteSession("session1");

        // Access to deleted session
        try {
            System.out.println(session1.getId());
        } catch (Exception e) {
            System.out.println("Session not found: " + e.getMessage());
        }
    }
}