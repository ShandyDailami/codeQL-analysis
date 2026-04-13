public class java_29652_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_29652_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, User user) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(user));
        }
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public User getUserFromSession(String sessionId) {
        return sessions.get(sessionId).getUser();
    }

    private class Session {
        private User user;

        public java_29652_SessionManager_A07(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}