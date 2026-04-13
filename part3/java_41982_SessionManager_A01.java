public class java_41982_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;
    private Transaction transaction;

    private java_41982_SessionManager_A01() {
        // Private constructor to restrict instantiation from outside
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void beginTransaction() {
        try {
            transaction = session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            transaction.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        session.close();
    }
}