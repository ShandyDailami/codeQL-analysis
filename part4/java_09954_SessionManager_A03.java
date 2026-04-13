public class java_09954_SessionManager_A03 {
    private int sessionCount = 0;

    public Session openSession() {
        sessionCount++;
        return new SessionImpl(sessionCount);
    }

    private class SessionImpl implements Session {
        private int sessionId;

        SessionImpl(int sessionId) {
            this.sessionId = sessionId;
        }

        public void close() {
            sessionCount--;
        }

        public Object get(String id) {
            return null; // replace with actual implementation
        }

        public void set(String id, Object value) {
            // replace with actual implementation
        }
    }
}