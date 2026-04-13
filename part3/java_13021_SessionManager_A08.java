public class java_13021_SessionManager_A08 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_13021_SessionManager_A08(String url, String username, String password) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", username);
        configuration.setProperty("hibernate.connection.password", password);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.current_session_context_class", "org.hibernate.ctx.ThreadContext");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionManager getInstance(String url, String username, String password) {
        if (sessionManager == null) {
            sessionManager = new SessionManager(url, username, password);
        }
        return sessionManager;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void save(Object entity) {
        Session session = openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
    }

    public void update(Object entity) {
        Session session = openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
    }

    public void delete(Object entity) {
        Session session = openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
    }

    public void query(String queryString) {
        Session session = openSession();
        Query query = session.createQuery(queryString);
        List results = query.list();
        session.close();
        // do something with the results
    }
}