public class java_22101_SessionManager_A01 {
    // A map to store active sessions
    private Map<String, Session> activeSessions;

    public java_22101_SessionManager_A01() {
        activeSessions = new HashMap<>();
    }

    // Start a new session
    public String startSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, userId, System.currentTimeMillis());
        activeSessions.put(sessionId, session);
        return sessionId;
    }

    // End a session
    public void endSession(String sessionId) {
        Session session = activeSessions.get(sessionId);
        if (session != null) {
            activeSessions.remove(sessionId);
            session.end();
        }
    }

    // Get the active sessions
    public Collection<Session> getActiveSessions() {
        return activeSessions.values();
    }

    // Session class
    public static class Session {
        private String id;
        private String userId;
        private long startTime;

        public java_22101_SessionManager_A01(String id, String userId, long startTime) {
            this.id = id;
            this.userId = userId;
            this.startTime = startTime;
        }

        public void end() {
            this.startTime = System.currentTimeMillis();
        }

        public String getUserId() {
            return userId;
        }

        public long getElapsedTime() {
            return System.currentTimeMillis() - startTime;
        }
    }
}