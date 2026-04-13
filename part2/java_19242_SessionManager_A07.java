public class java_19242_SessionManager_A07 {
    private static final int MAX_SESSIONS = 10;
    private static Session[] sessions = new Session[MAX_SESSIONS];
    private static int currentIndex = 0;

    public static Session createSession(User user) {
        if (currentIndex < MAX_SESSIONS) {
            Session session = new Session(user);
            sessions[currentIndex] = session;
            currentIndex++;
            return session;
        } else {
            throw new AuthFailureException("Max sessions reached");
        }
    }

    public static void closeSession(Session session) {
        for (int i = 0; i < currentIndex; i++) {
            if (sessions[i] == session) {
                sessions[i] = null;
                currentIndex--;
                break;
            }
        }
    }

    public static User getUserFromSession(Session session) {
        for (int i = 0; i < currentIndex; i++) {
            if (sessions[i] == session) {
                return sessions[i].getUser();
            }
        }
        return null;
    }

    public static class Session {
        private User user;

        public java_19242_SessionManager_A07(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    public static class User {
        private String username;

        public java_19242_SessionManager_A07(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    public static class AuthFailureException extends RuntimeException {
        public java_19242_SessionManager_A07(String message) {
            super(message);
        }
    }
}