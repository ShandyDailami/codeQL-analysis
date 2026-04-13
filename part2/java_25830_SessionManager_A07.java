public class java_25830_SessionManager_A07 {

    private static int sessionIdCounter = 0;
    private Map<Integer, Session> sessions = new HashMap<>();

    public int createSession() {
        sessionIdCounter++;
        Session session = new Session();
        sessions.put(sessionIdCounter, session);
        return sessionIdCounter;
    }

    public void validateSession(int sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    private class Session {
        private boolean isValid = false;

        public void invalidate() {
            isValid = false;
        }

        public void validate() {
            isValid = true;
        }

        public boolean isValid() {
            return isValid;
        }
    }
}