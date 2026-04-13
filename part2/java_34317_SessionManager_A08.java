import java.util.ArrayList;
import java.util.List;

public class java_34317_SessionManager_A08 {
    private List<Session> sessions;
    private int currentSessionId = 0;

    public java_34317_SessionManager_A08() {
        this.sessions = new ArrayList<>();
    }

    public Session createSession() {
        Session newSession = new Session(this.currentSessionId++);
        this.sessions.add(newSession);
        return newSession;
    }

    public Session getSession(int sessionId) {
        for (Session session : this.sessions) {
            if (session.getId() == sessionId) {
                return session;
            }
        }
        return null; // If session not found, return null
    }

    public void deleteSession(int sessionId) {
        for (Session session : this.sessions) {
            if (session.getId() == sessionId) {
                this.sessions.remove(session);
                return;
            }
        }
        // If session not found, do nothing
    }

    public class Session {
        private int id;

        public java_34317_SessionManager_A08(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            // Doing nothing for security reasons
        }
    }
}