public class java_17740_SessionManager_A08 {
    // SessionFactory is a thread-safe factory for creating sessions
    private final SessionFactory sessionFactory;

    public java_17740_SessionManager_A08(String connectionURL, String driverName, String userName, String password) {
        try {
            // Create the session factory with the connection URL, driver name, username and password
            sessionFactory = new Configuration().configure(new URL(connectionURL)).configure(driverName).configure(userName).configure(password).buildSessionFactory();
        } catch (ExceptionInInitializerError e) {
            throw new ExceptionInInitializerError("Error creating session factory", e);
        }
    }

    public Session getSession() {
        // Return a new session
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        // Closes the session if it is not null
        if (session != null) {
            session.close();
        }
    }

    public void closeSessionFactory() {
        // Close the session factory
        sessionFactory.close();
    }

    public void update(String query, Object... params) {
        Session session = getSession();
        try {
            Query q = session.createQuery(query);
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
            q.executeUpdate();
        } finally {
            closeSession(session);
        }
    }

    public <T> T find(String query, Object... params) {
        Session session = getSession();
        try {
            Query q = session.createQuery(query);
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
            return (T) q.uniqueResult();
        } finally {
            closeSession(session);
        }
    }
}