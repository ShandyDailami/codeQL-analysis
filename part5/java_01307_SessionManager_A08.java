public class java_01307_SessionManager_A08 {

    private static SessionManager instance;

    private java_01307_SessionManager_A08() {
        // Private constructor to prevent instantiation of this class
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Map<String, Session> sessions = new HashMap<>();

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID: " + sessionId + " already exists");
        }

        Session session = new Session();
        session.setId(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session with ID: " + sessionId + " does not exist");
        }

        return session;
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session with ID: " + sessionId + " does not exist");
        }

        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void destroy() {
            SessionManager.getInstance().closeSession(id);
        }
    }
}