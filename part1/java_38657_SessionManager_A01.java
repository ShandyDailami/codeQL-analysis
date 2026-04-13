import java.util.ArrayList;
import java.util.List;

public class java_38657_SessionManager_A01 {
    private List<Session> sessions = new ArrayList<>();

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void deleteSession(Session session) {
        sessions.remove(session);
    }

    public class Session {
        private boolean isClosed = false;

        public void closeSession() {
            if (!isClosed) {
                // Security-sensitive operation: Remove user from the session
                // For the sake of simplicity, we'll remove the session from the list
                // in a real application, you'd want to implement a more secure method
                SessionManager.this.sessions.remove(SessionManager.this);
                isClosed = true;
            }
        }

        public void openSession() {
            if (isClosed) {
                // Security-sensitive operation: Add user to the session
                // Again, for the sake of simplicity, we'll add the session to the list
                // in a real application, you'd want to implement a more secure method
                SessionManager.this.sessions.add(SessionManager.this);
                isClosed = false;
            }
        }
    }
}