public class java_00202_SessionManager_A07 {

    private SessionFactory sessionFactory;

    public java_00202_SessionManager_A07(String url, String username, String password, String driverName) {
        try {
            Class.forName(driverName);
            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }

    public Session openSessionWithAuth(String username, String password) {
        Session session = openSession();
        session.beginTransaction();
        session.setProperty("username", username);
        session.setProperty("password", password);
        session.getTransaction().commit();
        return session;
    }

    public void closeSessionWithAuth(Session session, String username, String password) {
        session.setProperty("username", username);
        session.setProperty("password", password);
        session.getTransaction().commit();
        closeSession(session);
    }
}