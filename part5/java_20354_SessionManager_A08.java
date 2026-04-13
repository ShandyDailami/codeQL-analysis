import java.util.HashMap;
import java.util.Map;

public class java_20354_SessionManager_A08 {

    private Map<String, Session> sessions;

    public java_20354_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String identifier) {
        if (sessions.containsKey(identifier)) {
            throw new IllegalStateException("Session with identifier " + identifier + " already exists.");
        }
        Session session = new Session(identifier);
        sessions.put(identifier, session);
        return session;
    }

    public Session getSession(String identifier) {
        Session session = sessions.get(identifier);
        if (session == null) {
            throw new IllegalStateException("No session with identifier " + identifier + " exists.");
        }
        return session;
    }

    public void destroySession(String identifier) {
        Session session = sessions.remove(identifier);
        if (session == null) {
            throw new IllegalStateException("No session with identifier " + identifier + " exists.");
        }
    }

    public static class Session {
        private String identifier;

        public java_20354_SessionManager_A08(String identifier) {
            this.identifier = identifier;
        }

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }
    }
}