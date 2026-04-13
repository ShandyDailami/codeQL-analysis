public class java_01629_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_01629_SessionManager_A08() {
        sessions = new HashMap<String, Session>();
    }

    public Session getSession(String id) {
        if (sessions.containsKey(id)) {
            return sessions.get(id);
        } else {
            Session session = new Session(id);
            sessions.put(id, session);
            return session;
        }
    }

    public void closeSession(String id) {
        if (sessions.containsKey(id)) {
            sessions.remove(id);
        }
    }

    public void closeAllSessions() {
        sessions.clear();
    }

    private class Session {
        private String id;

        public java_01629_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void close() {
            SessionManager.this.closeSession(this.id);
        }
    }
}