import java.util.ArrayList;
import java.util.List;

public class java_24884_SessionManager_A07 {

    private List<Session> sessions;

    public java_24884_SessionManager_A07() {
        sessions = new ArrayList<>();
    }

    public String createSession() {
        Session session = new Session();
        sessions.add(session);
        return session.getId();
    }

    public Session getSession(String id) {
        for (Session session : sessions) {
            if (session.getId().equals(id)) {
                return session;
            }
        }
        return null;
    }

    public void deleteSession(String id) {
        sessions.removeIf(session -> session.getId().equals(id));
    }

    public class Session {

        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}