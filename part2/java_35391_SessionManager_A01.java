import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_35391_SessionManager_A01 {
    private Map<UUID, Session> sessionMap;

    public java_35391_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(UUID id) {
        return sessionMap.get(id);
    }

    public void createSession(Session session) {
        sessionMap.put(session.getId(), session);
    }

    public void removeSession(UUID id) {
        sessionMap.remove(id);
    }

    public static class Session {
        private UUID id;

        public java_35391_SessionManager_A01() {
            this.id = UUID.randomUUID();
        }

        public UUID getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.getSession(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        System.out.println("Session 1 ID: " + session1.getId());

        Session session2 = sessionManager.getSession(UUID.fromString("00000000-0000-0000-0000-000000000002"));
        System.out.println("Session 2 ID: " + session2.getId());

        sessionManager.createSession(new Session());

        Session session3 = sessionManager.getSession(UUID.fromString("00000000-0000-0000-0000-000000000003"));
        System.out.println("Session 3 ID: " + session3.getId());

        sessionManager.removeSession(session1.getId());

        session3 = sessionManager.getSession(session3.getId());
        System.out.println("Session 3 ID after removal: " + session3.getId());
    }
}