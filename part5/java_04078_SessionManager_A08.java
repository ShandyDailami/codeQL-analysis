import java.util.ArrayList;
import java.util.List;

public class java_04078_SessionManager_A08 {
    private List<Session> sessions;
    private int currentSessionIndex;

    public java_04078_SessionManager_A08() {
        sessions = new ArrayList<>();
        currentSessionIndex = -1;
    }

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public Session getCurrentSession() {
        if (currentSessionIndex == -1) {
            throw new IllegalStateException("No current session");
        }
        return sessions.get(currentSessionIndex);
    }

    public void closeCurrentSession() {
        if (currentSessionIndex == -1) {
            throw new IllegalStateException("No current session");
        }
        sessions.get(currentSessionIndex).close();
        currentSessionIndex = -1;
    }

    public void setCurrentSession(Session session) {
        if (currentSessionIndex != -1 && currentSessionIndex != sessions.indexOf(session)) {
            throw new IllegalStateException("Invalid session");
        }
        currentSessionIndex = sessions.indexOf(session);
    }

    public class Session {
        private boolean isOpen;

        public void open() {
            isOpen = true;
        }

        public void close() {
            isOpen = false;
        }

        public boolean isOpen() {
            return isOpen;
        }
    }
}