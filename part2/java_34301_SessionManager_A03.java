public class java_34301_SessionManager_A03 {

    private static SessionManager instance;
    private static Session session;

    private java_34301_SessionManager_A03() {
        // private constructor to prevent instantiation of the class
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }

}