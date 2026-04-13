import java.util.ArrayList;
import java.util.List;

public class java_21837_SessionManager_A08 {

    private List<Session> sessions;

    public java_21837_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(int sessionId) {
        sessions.removeIf(session -> session.getId() == sessionId);
    }

    public Session getSession(int sessionId) {
        return sessions.stream().filter(session -> session.getId() == sessionId).findFirst().orElse(null);
    }

    public void updateSession(Session session) {
        removeSession(session.getId());
        addSession(session);
    }

    public static class Session {

        private int id;
        private String details;

        public java_21837_SessionManager_A08(int id) {
            this.id = id;
            this.details = "Session " + id;
        }

        public int getId() {
            return id;
        }

        public String getDetails() {
            return details;
        }
    }
}