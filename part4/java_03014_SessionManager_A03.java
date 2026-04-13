public class java_03014_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_03014_SessionManager_A03() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}