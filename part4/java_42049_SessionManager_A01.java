public class java_42049_SessionManager_A01 {
    private HashMap<String, Session> sessions = new HashMap<>();

    public Session getSession(String id) {
        if (sessions.containsKey(id)) {
            return sessions.get(id);
        }
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    public void closeSession(String id) {
        if (sessions.containsKey(id)) {
            sessions.remove(id);
        }
    }

    private class Session {
        private String id;

        public java_42049_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}