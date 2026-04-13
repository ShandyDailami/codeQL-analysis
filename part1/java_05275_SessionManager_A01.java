import java.util.HashMap;
import java.util.Map;

public class java_05275_SessionManager_A01 {

    private Map<String, Session> sessionMap;

    public java_05275_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String name) {
        Session session = sessionMap.get(name);
        if (session == null) {
            session = createSession(name);
            sessionMap.put(name, session);
        }
        return session;
    }

    private Session createSession(String name) {
        // This is a placeholder for the actual session creation logic.
        // Please replace it with your actual session creation logic.
        System.out.println("Creating a new session for name: " + name);
        return new SessionImpl();
    }

    public void closeSession(Session session) {
        sessionMap.remove(session.getName());
        // This is a placeholder for the actual session closure logic.
        // Please replace it with your actual session closure logic.
        System.out.println("Closing the session for name: " + session.getName());
    }

    public void closeAllSessions() {
        for (Session session : sessionMap.values()) {
            closeSession(session);
        }
    }

    // This is a placeholder for the actual session interface.
    // Please replace it with your actual session interface.
    public interface Session {
        String getName();
    }

    private class SessionImpl implements Session {
        private String name;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void close() {
            // This is a placeholder for the actual session closure logic.
            // Please replace it with your actual session closure logic.
            System.out.println("Closing the session for name: " + getName());
        }
    }
}