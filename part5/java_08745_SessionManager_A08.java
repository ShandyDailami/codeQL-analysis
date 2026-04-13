public class java_08745_SessionManager_A08 {
    private static Session session;

    private java_08745_SessionManager_A08() {
        // Private constructor to prevent instantiation of the class
    }

    public static Session getSession() {
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public static void closeSession() {
        if (session != null) {
            session.close();
            session = null;
        }
    }
}