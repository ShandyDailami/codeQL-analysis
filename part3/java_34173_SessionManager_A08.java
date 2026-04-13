public class java_34173_SessionManager_A08 {

    private SessionFactory sessionFactory;

    public java_34173_SessionManager_A08(String hibernateConfigFile) {
        try {
            sessionFactory = new Configuration().configure(hibernateConfigFile).buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        closeSession(session);
    }

    public void update(Object entity) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        closeSession(session);
    }

    public void delete(Object entity) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        closeSession(session);
    }
}