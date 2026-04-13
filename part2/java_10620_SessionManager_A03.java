import java.util.HashMap;

public class java_10620_SessionManager_A03 {
    private HashMap<Integer, Session> sessions;
    private int sessionIdCounter = 0;

    public java_10620_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        sessionIdCounter++;
        Session newSession = new Session(sessionIdCounter);
        sessions.put(newSession.getSessionId(), newSession);
        return newSession;
    }

    public Session getSession(int sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(int sessionId) {
        sessions.remove(sessionId);
    }

    // Session class
    public class Session {
        private int sessionId;

        public java_10620_SessionManager_A03(int sessionId) {
            this.sessionId = sessionId;
        }

        public int getSessionId() {
            return sessionId;
        }
    }
}