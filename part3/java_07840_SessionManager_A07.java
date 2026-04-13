public class java_07840_SessionManager_A07 {
    private static int sessionCount = 0;

    public static class Session {
        private static int sessionIdCounter = 0;
        private int sessionId;

        private java_07840_SessionManager_A07() {
            sessionId = createSessionId();
        }

        private static int createSessionId() {
            return sessionIdCounter++;
        }

        public int getSessionId() {
            return sessionId;
        }
    }

    public Session createSession() {
        return new Session();
    }

    public void closeSession(Session session) {
        // Session closing operation here, but it's not a security sensitive operation.
        // Here for the example.
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Create a new session.
        Session session1 = sm.createSession();
        System.out.println("Created session: " + session1.getSessionId());

        // Create another session.
        Session session2 = sm.createSession();
        System.out.println("Created session: " + session2.getSessionId());

        // Close the first session.
        sm.closeSession(session1);

        // Try to create a new session.
        Session session3 = sm.createSession();
        System.out.println("Created session: " + session3.getSessionId());
    }
}