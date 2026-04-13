public class java_29192_SessionManager_A03 {
    // This is our private session counter.
    private int sessionCounter;

    // This method creates a new session.
    public Session createSession() {
        Session session = new SessionImpl(this);
        sessionCounter++;
        System.out.println("Session " + sessionCounter + " created.");
        return session;
    }

    // This method closes a session.
    public void closeSession(Session session) {
        if (session != null) {
            session.close();
            System.out.println("Session " + sessionCounter + " closed.");
            sessionCounter--;
        }
    }

    public static void main(String[] args) {
        SecureSessionManager manager = new SecureSessionManager();

        // Use the manager to create and close sessions.
        manager.createSession();
        manager.createSession();
        manager.closeSession(manager.createSession());
        manager.closeSession(manager.createSession());
    }
}