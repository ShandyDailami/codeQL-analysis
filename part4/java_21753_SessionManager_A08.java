import java.util.HashMap;
import java.util.Map;

public class java_21753_SessionManager_A08 {

    private static Map<String, Session> sessions;

    static {
        sessions = new HashMap<>();
    }

    public static Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new DefaultSession(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public static void updateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.update();
        }
    }

    public static void deleteSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
            session.delete();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        Session s1 = sm.getSession("session1");
        s1.connect();

        Session s2 = sm.getSession("session2");
        s2.connect();

        sm.updateSession("session1");
        sm.deleteSession("session2");

        s1.disconnect();
        s2.disconnect();
    }

    private interface Session {
        void connect();
        void disconnect();
        void update();
        void delete();
    }

    private static class DefaultSession implements Session {

        private String sessionId;
        private boolean connected;

        public java_21753_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public void connect() {
            System.out.println("Connecting to session: " + sessionId);
            connected = true;
        }

        @Override
        public void disconnect() {
            System.out.println("Disconnecting from session: " + sessionId);
            connected = false;
        }

        @Override
        public void update() {
            if (connected) {
                System.out.println("Updating session: " + sessionId);
            } else {
                System.out.println("Error: Session: " + sessionId + " is not connected.");
            }
        }

        @Override
        public void delete() {
            System.out.println("Deleting session: " + sessionId);
        }
    }
}