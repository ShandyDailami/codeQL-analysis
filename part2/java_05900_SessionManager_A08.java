import java.util.HashMap;
import java.util.Map;

public class java_05900_SessionManager_A08 implements Session {
    private Map<String, Session> sessions;

    public java_05900_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    @Override
    public String createSession(String userId) {
        if (sessions.containsKey(userId)) {
            throw new SecurityFailureException("Duplicate session creation for user: " + userId);
        }

        String sessionId = userId + "_" + System.currentTimeMillis();
        sessions.put(sessionId, new SessionImpl(userId, sessionId));
        return sessionId;
    }

    @Override
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new SecurityFailureException("Invalid session: " + sessionId);
        }
        return session;
    }

    @Override
    public void closeSession(String sessionId) {
        Session session = sessions.remove(sessionId);
        if (session == null) {
            throw new SecurityFailureException("Unknown session: " + sessionId);
        }
    }

    private static class SessionImpl implements Session {
        private String userId;
        private String sessionId;

        public java_05900_SessionManager_A08(String userId, String sessionId) {
            this.userId = userId;
            this.sessionId = sessionId;
        }

        @Override
        public String getUserId() {
            return userId;
        }

        @Override
        public String getSessionId() {
            return sessionId;
        }

        @Override
        public void setUserId(String userId) {
            throw new UnsupportedOperationException("User IDs cannot be changed");
        }

        @Override
        public void setSessionId(String sessionId) {
            throw new UnsupportedOperationException("Session IDs cannot be changed");
        }
    }
}