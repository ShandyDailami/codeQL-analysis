public class java_28659_SessionManager_A08 {
    private static final int MAX_SESSIONS = 10;
    private static final List<Session> activeSessions = new ArrayList<>();

    public static class Session {
        public Session invalidate() {
            activeSessions.remove(this);
            return this;
        }
    }

    public static Session startSession() {
        if(activeSessions.size() < MAX_SESSIONS) {
            Session session = new Session();
            activeSessions.add(session);
            return session;
        } else {
            // Handle this situation. For example, you can return null, or throw an exception
            throw new RuntimeException("Maximum number of sessions (" + MAX_SESSIONS + ") reached.");
        }
    }

    public static void main(String[] args) {
        // Start a new session
        Session session = startSession();

        // Do some work with the session...

        // Invalidate the session
        session.invalidate();

        // Attempt to start a new session, but this should fail
        try {
            session = startSession();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}