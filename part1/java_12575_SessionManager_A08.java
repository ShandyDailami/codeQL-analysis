public class java_12575_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_12575_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String userId) {
        // Check if the session already exists
        if (sessions.containsKey(userId)) {
            return sessions.get(userId);
        }

        // Create a new session
        Session session = new Session(userId);
        sessions.put(userId, session);

        return session;
    }

    public void deleteSession(String userId) {
        // Check if the session exists
        if (sessions.containsKey(userId)) {
            sessions.remove(userId);
       
        }
    }

    public class Session {
        private String userId;

        public java_12575_SessionManager_A08(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}