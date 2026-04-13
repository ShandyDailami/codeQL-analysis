import java.util.HashMap;
import java.util.Map;

public class java_11225_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_11225_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public Session createSession(String user) {
        Session session = new Session(user);
        sessions.put(user, session);
        return session;
    }

    public void destroySession(String user) {
        sessions.remove(user);
    }

    private class Session {
        private String user;

        public java_11225_SessionManager_A01(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }
}