public class java_28754_SessionManager_A08 {

    // Define a session map
    private Map<String, Session> sessionMap;

    // Default constructor
    public java_28754_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a unique session id
        String sessionId = UUID.randomUUID().toString();

        // Create a new session and save it into the map
        Session session = new Session(sessionId, userId);
        sessionMap.put(sessionId, session);

        return sessionId;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;
        private String userId;

        public java_28754_SessionManager_A08(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
        }

        // Getters and setters
        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}