import java.util.Stack;

public class java_27446_SessionManager_A03 {
    private Stack<Session> sessions = new Stack<>();
    private long sessionIdCounter = 0;

    public long beginSession() {
        sessions.push(new Session(++sessionIdCounter));
        return sessionIdCounter;
    }

    public void endSession(long sessionId) {
        sessions.pop();
    }

    public Session getSession(long sessionId) {
        for (Session session : sessions) {
            if (session.getId() == sessionId) {
                return session;
            }
        }
        throw new RuntimeException("Session not found");
    }

    public static class Session {
        private long id;

        public java_27446_SessionManager_A03(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }
    }
}