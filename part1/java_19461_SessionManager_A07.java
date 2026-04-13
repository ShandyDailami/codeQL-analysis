import java.util.LinkedList;

public class java_19461_SessionManager_A07 {
    private LinkedList<Session> sessions = new LinkedList<>();

    public class Session {
        private String username;

        public java_19461_SessionManager_A07(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    public Session createSession(String username) {
        Session session = new Session(username);
        sessions.add(session);
        return session;
    }

    public void invalidateSession(Session session) {
        sessions.remove(session);
    }

    public Session getSession(String username) {
        for (Session session : sessions) {
            if (session.getUsername().equals(username)) {
                return session;
            }
        }
        return null;
    }
}