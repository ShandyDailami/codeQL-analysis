public class java_06366_SessionManager_A08 {
    private int sessionIdCounter = 0;
    private HashMap<Integer, Session> sessions = new HashMap<>();

    public Session createSession() {
        Session session = new Session(sessionIdCounter++);
        sessions.put(session.getId(), session);
        return session;
    }

    public Session getSession(int sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(int sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private int id;

        public java_06366_SessionManager_A08(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void close() {
            SessionManager.this.removeSession(id);
        }
    }
}