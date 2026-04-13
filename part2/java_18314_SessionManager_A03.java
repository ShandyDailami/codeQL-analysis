import java.util.HashMap;
import java.util.Map;

public class java_18314_SessionManager_A03 {

    // Private HashMap to store session data
    private Map<String, Session> sessionMap;

    // Public constructor
    public java_18314_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        Session session = new SessionImpl(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            session.close();
            sessionMap.remove(sessionId);
        }
    }

    // Session implementation
    private class SessionImpl implements Session {
        private String id;
        private boolean isOpen;

        public java_18314_SessionManager_A03(String id) {
            this.id = id;
            this.isOpen = true;
        }

        @Override
        public void close() {
            isOpen = false;
        }

        @Override
        public boolean isOpen() {
            return isOpen;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        Session session1 = manager.createSession("session1");
        System.out.println("Created session: " + session1.isOpen());

        // Get a session
        Session session2 = manager.getSession("session1");
        System.out.println("Got session: " + session2.isOpen());

        // Close a session
        manager.closeSession("session1");
        System.out.println("Closed session: " + session2.isOpen());
    }
}