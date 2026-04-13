public class java_34200_SessionManager_A08 {
    private Session session;

    public java_34200_SessionManager_A08() {
        // Use this line to open a session and bind it to a connection pool.
        // Use the following line to open a session without binding it to a connection pool.
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        try {
            sm.getSession().beginTransaction();
            // ... perform operations
            sm.getSession().getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            sm.getSession().getTransaction().rollback();
        } finally {
            sm.closeSession();
        }
    }
}