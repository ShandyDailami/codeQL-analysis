import java.util.ArrayList;
import java.util.List;

public class java_06972_SessionManager_A01 {
    private List<Session> sessions;

    public java_06972_SessionManager_A01() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public Session getSession(int index) {
        if (index >= 0 && index < sessions.size()) {
            return sessions.get(index);
        }
        return null;
    }

    public static class Session {
        private String id;
        private String userId;

        public java_06972_SessionManager_A01(String id, String userId) {
            this.id = id;
            this.userId = userId;
        }

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }
    }
}