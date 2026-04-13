public class java_30815_SessionManager_A08 {
    private static int currentSessionId = 0;
    private Session[] sessions = new Session[10];

    public java_30815_SessionManager_A08() {
        // Initialize sessions with unique ids
        for (int i = 0; i < sessions.length; i++) {
            sessions[i] = new Session();
            sessions[i].setId(++currentSessionId);
        }
    }

    public Session getSession(int id) {
        // Find the session with the given id
        for (Session session : sessions) {
            if (session.getId() == id) {
                return session;
            }
        }
        // If no session is found, return null
        return null;
    }

    public void closeSession(int id) {
        // Find the session with the given id and close it
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i].getId() == id) {
                sessions[i].setClosed(true);
                return;
            }
        }
    }

    public static class Session {
        private int id;
        private boolean closed = false;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isClosed() {
            return closed;
        }

        public void setClosed(boolean closed) {
            this.closed = closed;
        }
    }
}