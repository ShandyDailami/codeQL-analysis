public class java_19283_SessionManager_A08 {
    private static SessionManager instance;
    private java_19283_SessionManager_A08() {
        // Private constructor to prevent instantiation from outside
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private HashMap<String, Session> sessions = new HashMap<>();

    public Session openSession(String dbName) {
        Session session = new Session();
        sessions.put(dbName, session);
        return session;
    }

    public void closeSession(String dbName) {
        sessions.remove(dbName);
    }

    public void integrityCheck(String dbName) {
        Session session = sessions.get(dbName);
        if (session == null) {
            throw new RuntimeException("Session not found for database: " + dbName);
        }
        // Perform integrity check here
    }
}

public class Session {
    private String dbName;
    // ... Other session details

    public void integrityCheck() {
        SessionManager.getInstance().integrityCheck(dbName);
    }
}