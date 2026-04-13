public class java_14588_SessionManager_A08 {

    private static int MAX_SESSIONS = 100;
    private static int activeSessions = 0;

    private static Session[] sessions = new Session[MAX_SESSIONS];

    public static class Session {
        private String id;
        private User user;

        public java_14588_SessionManager_A08(String id, User user) {
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
        private String name;

        public java_14588_SessionManager_A08(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static Session createSession(String id, User user) {
        if (activeSessions >= MAX_SESSIONS) {
            throw new RuntimeException("Maximum sessions reached.");
        }

        Session session = new Session(id, user);
        sessions[activeSessions++] = session;
        return session;
    }

    public static void deleteSession(Session session) {
        for (int i = 0; i < activeSessions; i++) {
            if (sessions[i] == session) {
                sessions[i] = null;
                activeSessions--;
                return;
            }
        }
    }

    public static Session getSession(String id) {
        for (int i = 0; i < activeSessions; i++) {
            if (sessions[i] != null && sessions[i].getId().equals(id)) {
                return sessions[i];
            }
        }
        return null;
    }

    public static User getUser(Session session) {
        return session.getUser();
    }
}