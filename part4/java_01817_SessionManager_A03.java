public class java_01817_SessionManager_A03 {
    // Define a static hashmap for managing session objects
    private Map<String, Session> sessionMap;

    // Constructor
    public java_01817_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_01817_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        // Getters and setters for sessionId
        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}