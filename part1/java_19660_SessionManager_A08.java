import java.util.*;

public class java_19660_SessionManager_A08 {
    // Define a HashMap to store sessions
    private HashMap<String, Session> sessionMap;

    public java_19660_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // A Session class
    public class Session {
        private String id;
        private String userId;
        private Date loginTime;
        private Date lastAccessed;

        public java_19660_SessionManager_A08(String id, String userId) {
            this.id = id;
            this.userId = userId;
            this.loginTime = new Date();
            this.lastAccessed = new Date();
        }

        public void updateLastAccessed() {
            this.lastAccessed = new Date();
        }

        public String getId() {
            return this.id;
        }

        public String getUserId() {
            return this.userId;
        }

        public Date getLoginTime() {
            return this.loginTime;
        }

        public Date getLastAccessed() {
            return this.lastAccessed;
        }
    }

    // Method to create a new session for a user
    public Session createSession(String userId) {
        // Generate a new session ID
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, userId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to update the last access time for a session
    public void updateSessionLastAccessed(String sessionId) {
        // Check if the session exists
        if (sessionMap.containsKey(sessionId)) {
            Session session = sessionMap.get(sessionId);
            session.updateLastAccessed();
        }
    }

    // Method to get a session based on the session ID
    public Session getSession(String sessionId) {
        // Check if the session exists
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to expire a session
    public void expireSession(String sessionId) {
        // Check if the session exists
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}