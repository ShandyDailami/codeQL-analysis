public class java_10317_SessionManager_A01 {
    private static SessionManager instance;
    private Session currentSession;

    private java_10317_SessionManager_A01() {
        // Private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session openSession() {
        Session session = new SessionImpl();
        session.setAttribute("connected", true);
        this.currentSession = session;
        return session;
    }

    public void closeSession() {
        if (currentSession != null) {
            currentSession.setAttribute("connected", false);
            this.currentSession = null;
        }
    }
}

public class SessionImpl implements Session {
    private Map<String, Object> attributes = new HashMap<>();

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    @Override
    public void removeAttribute(String name) {
        attributes.remove(name);
    }
}