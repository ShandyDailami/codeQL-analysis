import java.util.ArrayList;
import java.util.Random;

public class java_07600_SessionManager_A03 {
    private ArrayList<Session> sessions;
    private Random random;

    public java_07600_SessionManager_A03() {
        sessions = new ArrayList<>();
        random = new Random();
    }

    public String createSession() {
        String sessionId = generateSessionId();
        sessions.add(new Session(sessionId));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }

    public void destroySession(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                sessions.remove(session);
                return;
            }
        }
    }

    private String generateSessionId() {
        return String.valueOf(random.nextLong());
    }

    private class Session {
        private String id;

        public java_07600_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}