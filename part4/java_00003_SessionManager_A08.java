public class java_00003_SessionManager_A08 {

    private static final int EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour
    private static HashMap<String, UserSession> sessions;

    public static class UserSession {
        public String user;
        public long creationTime;

        public java_00003_SessionManager_A08(String user) {
            this.user = user;
            this.creationTime = System.currentTimeMillis();
        }
    }

    public java_00003_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String user) {
        UserSession session = new UserSession(user);
        sessions.put(user, session);
    }

    public void endSession(String user) {
        sessions.remove(user);
    }

    public boolean isSessionActive(String user) {
        if (!sessions.containsKey(user)) {
            return false;
        }

        UserSession session = sessions.get(user);
        long currentTime = System.currentTimeMillis();

        if (currentTime - session.creationTime > EXPIRATION_TIME) {
            // Session expired
            sessions.remove(user);
            return false;
        }

        return true;
    }
}