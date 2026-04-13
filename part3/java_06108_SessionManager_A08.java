public class java_06108_SessionManager_A08 {

    private static List<Session> sessions = new ArrayList<>();

    public static class Session {
        private String id;
        private User user;

        public java_06108_SessionManager_A08(String id, User user) {
            this.id = id;
            this.user = user;
        }

        public String getId() {
            return id;
        }

        public User getUser() {
            return user;
        }
    }

    public static class User {
        private String id;
        private String name;

        public java_06108_SessionManager_A08(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public Session createSession(User user) {
        String id = UUID.randomUUID().toString();
        Session session = new Session(id, user);
        sessions.add(session);
        return session;
    }

    public User readUser(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session.getUser();
            }
        }
        return null;
    }

    public void updateUser(String sessionId, User user) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                session.user = user;
            }
        }
    }

    public void deleteSession(String sessionId) {
        sessions.removeIf(session -> session.getId().equals(sessionId));
    }
}