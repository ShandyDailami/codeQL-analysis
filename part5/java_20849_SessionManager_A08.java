public class java_20849_SessionManager_A08 {

    private static final HashMap<String, Session> sessions = new HashMap<>();

    public static Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public static void createSession(String sessionId) {
        sessions.put(sessionId, new Session(sessionId));
    }

    public static void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private static class Session {
        private String id;

        public java_20849_SessionManager_A08(String id) {
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