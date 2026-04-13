import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class java_19740_SessionManager_A08 {

    private static class Session {
        private String id;
        private String data;

        public java_19740_SessionManager_A08(String data) {
            this.id = UUID.randomUUID().toString();
            this.data = data;
        }

        public String getId() {
            return id;
        }

        public String getData() {
            return data;
        }
    }

    private List<Session> sessions = new ArrayList<>();

    public void createSession(String data) {
        sessions.add(new Session(data));
    }

    public String getSessionData(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session.getData();
            }
        }
        return null;
    }

    public void destroySession(String sessionId) {
        sessions.removeIf(session -> session.getId().equals(sessionId));
    }
}