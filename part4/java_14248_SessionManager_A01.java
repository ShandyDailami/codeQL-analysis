import java.util.ArrayList;

public class java_14248_SessionManager_A01 {
    private ArrayList<Session> sessions;

    public java_14248_SessionManager_A01() {
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
        return null; // Return null if session not found
    }

    public void removeSession(String sessionId) {
        sessions.removeIf(session -> session.getId().equals(sessionId));
    }

    // This is a placeholder for a real-world application.
    // A real-world application would have additional methods for updating session data,
    // handling session expiration, etc.
    public class Session {
        private String id;

        public java_14248_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.new Session("session1");
        sessionManager.addSession(session1);

        Session session2 = sessionManager.getSession("session1");
        System.out.println(session2 != null); // Should print: true

        sessionManager.removeSession("session1");
        Session session3 = sessionManager.getSession("session1");
        System.out.println(session3 == null); // Should print: true
    }
}