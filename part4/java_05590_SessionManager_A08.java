import java.util.ArrayList;
import java.util.List;

public class java_05590_SessionManager_A08 {

    private List<Session> sessions;

    public java_05590_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public Session getSession() {
        if(sessions.isEmpty()){
            Session session = new Session();
            sessions.add(session);
            return session;
        } else {
            Session session = sessions.get(sessions.size() - 1);
            sessions.remove(session);
            return session;
        }
    }

    public void closeSession(Session session) {
        sessions.remove(session);
    }

    public static class Session {
        private boolean isClosed = false;

        public void close() {
            isClosed = true;
        }

        public boolean isClosed() {
            return isClosed;
        }
    }

    public static class IntegrityFailureException extends Exception {
        public java_05590_SessionManager_A08(String message) {
            super(message);
        }
    }

    public void checkIntegrity() throws IntegrityFailureException {
        for (Session session : sessions) {
            if (session.isClosed()) {
                throw new IntegrityFailureException("Session integrity failure detected.");
            }
        }
    }
}