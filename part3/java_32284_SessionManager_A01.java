public class java_32284_SessionManager_A01 {

    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();

    public static Session getSession() {
        Session session = sessionThreadLocal.get();
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
            sessionThreadLocal.set(session);
        }
        return session;
    }

    public static void setSession(Session session) {
        sessionThreadLocal.set(session);
    }

    public static void closeSession() {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            session.close();
            sessionThreadLocal.set(null);
        }
    }

    public static void main(String[] args) {
        // Create a new session
        Session session = HibernateUtil.getSessionFactory().openSession();
        sessionThreadLocal.set(session);

        // Start the transaction
        session.beginTransaction();

        // Perform some operations
        session.save(new User("John", "Doe"));

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}