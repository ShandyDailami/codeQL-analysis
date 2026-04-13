public class java_06902_SessionManager_A01 {
    private static SessionManager instance;

    private java_06902_SessionManager_A01() {
        // Private constructor to prevent instantiation from outside
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Map<String, Session> sessionMap;

    public void createSession(String sessionId) {
        sessionMap.put(sessionId, new Session(sessionId));
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private static class Session {
        private String id;

        public java_06902_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}