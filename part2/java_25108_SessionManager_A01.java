public class java_25108_SessionManager_A01 {
    private static final String SESSION_NAME = "SecureSession";
    private static final long SESSION_TIMEOUT = 10 * 60 * 1000; // 10 minutes

    private Map<String, Session> sessions = new HashMap<>();

    public java_25108_SessionManager_A01() {
        // Initialize session
        Session session = Hibernate.createSessionFactory().openSession();
        session.beginTransaction();
        // Create a new session
        Session newSession = session.get(Session.class, SESSION_NAME);
        if (newSession == null) {
            newSession = session.save(new Session(SESSION_NAME));
        }
        session.getTransaction().commit();
        session.close();
    }

    public Session getSession() {
        // Create a new session if one doesn't exist or if it's expired
        Session session = sessions.get(SESSION_NAME);
        if (session == null || session.getCreationTime() + SESSION_TIMEOUT < System.currentTimeMillis()) {
            session = Hibernate.createSessionFactory().openSession();
            session.beginTransaction();
            session = session.get(Session.class, SESSION_NAME);
            session.setCreationTime(System.currentTimeMillis());
            session.setAttribute("attribute", "secure data");
            session.getTransaction().commit();
            sessions.put(SESSION_NAME, session);
        }
        return session;
    }
}