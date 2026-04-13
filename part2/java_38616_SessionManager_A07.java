public class java_38616_SessionManager_A07 {
    private static SessionManager sessionManager;
    private Session session;

    private java_38616_SessionManager_A07() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static SessionManager getSessionManager() {
        if(sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void save(Object object) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Object object) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Object object) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}