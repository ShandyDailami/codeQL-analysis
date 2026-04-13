public class java_23705_SessionManager_A08 {
    // A simple way to store sessions in a list.
    private List<Session> sessions = new ArrayList<>();

    // Session class, just for demonstrating integrity.
    public static class Session {
        private String id;
        private boolean isValid;

        public java_23705_SessionManager_A08(String id) {
            this.id = id;
            // Initially, the session is valid.
            this.isValid = true;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isValid() {
            return isValid;
        }

        public void invalidate() {
            isValid = false;
        }
    }

    // Create a new session.
    public Session createSession(String id) {
        Session session = new Session(id);
        sessions.add(session);
        return session;
    }

    // Check if a session is valid.
    public boolean checkSessionIntegrity(String id) {
        for (Session session : sessions) {
            if (session.isValid() && session.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Invalidate a session.
    public void invalidateSession(String id) {
        for (Session session : sessions) {
            if (session.getId().equals(id)) {
                session.invalidate();
                return;
            }
        }
    }
}