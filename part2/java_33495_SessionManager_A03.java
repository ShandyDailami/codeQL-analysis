import java.util.Map;
import java.util.HashMap;

public class java_33495_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_33495_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(String name) {
        Session session = sessions.get(name);
        if (session == null) {
            session = new Session(name);
            sessions.put(name, session);
        }
        return session;
    }

    public void closeSession(Session session) {
        sessions.remove(session.getName());
    }

    public static class Session {
        private String name;

        public java_33495_SessionManager_A03(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            // TODO: Add security feature that sets the name of a session to something undesirable
            this.name = name;
        }
    }
}