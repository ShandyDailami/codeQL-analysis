public class java_41251_SessionManager_A08 {
    private int sessionCount = 0;

    public Session createSession() {
        Session session = new Session();
        session.setSessionId(++sessionCount);
        return session;
    }

    public void deleteSession(Session session) {
        // This is a mock integrity check, you would likely have some external system or database here
        // for checking the integrity of the session
        if (session.getSessionId() % 2 == 0) { // mock failure
            throw new IntegrityFailureException("Session " + session.getSessionId() + " failed integrity check");
        }
        System.out.println("Session " + session.getSessionId() + " deleted successfully");
    }

    public static class Session {
        private int sessionId;

        public int getSessionId() {
            return sessionId;
        }

        public void setSessionId(int sessionId) {
            this.sessionId = sessionId;
        }
    }

    public static class IntegrityFailureException extends RuntimeException {
        public java_41251_SessionManager_A08(String message) {
            super(message);
        }
    }
}