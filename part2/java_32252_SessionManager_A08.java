import java.util.ArrayList;
import java.util.List;

public class java_32252_SessionManager_A08 {
    private List<Session> sessions;

    public java_32252_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public void createSession(String sessionId) {
        if (sessionExists(sessionId)) {
            System.out.println("Session with ID " + sessionId + " already exists.");
            return;
        }
        sessions.add(new Session(sessionId));
    }

    public void deleteSession(String sessionId) {
        Session session = getSession(sessionId);
        if (session == null) {
            System.out.println("Session with ID " + sessionId + " does not exist.");
            return;
        }
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

    public boolean sessionExists(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return true;
            }
        }
        return false;
    }

    private class Session {
        private String id;

        public java_32252_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}