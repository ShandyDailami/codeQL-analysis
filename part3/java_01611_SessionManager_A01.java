public class java_01611_SessionManager_A01 {
    private static HashMap<String, Session> sessions = new HashMap<>();

    public static void startSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
    }

    public static Session getSession(String userId) {
        return sessions.get(userId);
    }

    public static void endSession(String userId) {
        sessions.remove(userId);
    }

    private static class Session {
        private String userId;

        public java_01611_SessionManager_A01(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}