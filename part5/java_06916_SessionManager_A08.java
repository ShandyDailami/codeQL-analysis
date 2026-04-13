public class java_06916_SessionManager_A08 {
    private static SessionManager instance;

    private java_06916_SessionManager_A08() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private HashMap<String, Session> sessions = new HashMap<>();

    public Session getSession(String name) {
        Session session = sessions.get(name);
        if (session == null) {
            session = createSession(name);
            sessions.put(name, session);
        }
        return session;
    }

    private Session createSession(String name) {
        // Implementation of creating a session
        return new Session();
    }
}

public class Session {
    private String name;

    public java_06916_SessionManager_A08(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Adding security-sensitive operations
        if (name != null && name.length() > 10) {
            throw new SecurityFailureException("Attempted to set session name with invalid length (must be 10 characters or less)");
        }
        this.name = name;
    }
}