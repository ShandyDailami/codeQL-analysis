public class java_40200_SessionManager_A01 {
    private static int sessionCount = 0;

    private java_40200_SessionManager_A01() {
        // Private constructor to prevent instantiation of the class
    }

    public static Session createSession() {
        sessionCount++;
        return new SessionImpl(sessionCount);
    }

    private static class SessionImpl implements Session {
        private int sessionId;

        SessionImpl(int sessionId) {
            this.sessionId = sessionId;
        }

        public void close() {
            System.out.println("Closing session with ID: " + sessionId);
        }
    }
}