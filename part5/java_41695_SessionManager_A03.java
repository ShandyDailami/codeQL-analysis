import java.util.HashMap;

public class java_41695_SessionManager_A03 {
    private HashMap<String, Session> sessions;

    public java_41695_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(Object user) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(user, sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public Object getSessionUser(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId).getUser();
        } else {
            return null;
        }
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private Object user;
        private String sessionId;

        public java_41695_SessionManager_A03(Object user, String sessionId) {
            this.user = user;
            this.sessionId = sessionId;
        }

        public Object getUser() {
            return user;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}