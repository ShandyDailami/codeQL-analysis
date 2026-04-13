public class java_14129_SessionManager_A08 {
    private int sessionCount = 0;

    public Session createSession() {
        Session newSession = new SessionImpl();
        sessionCount++;
        return newSession;
    }

    public void closeSession(Session session) {
        if (session == null) {
            return;
        }
        sessionCount--;
    }

    public void integrityCheck(Session session) {
        if (session == null || sessionCount <= 0) {
            throw new SecurityException("Invalid session");
        }
    }
}