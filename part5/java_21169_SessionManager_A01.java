public class java_21169_SessionManager_A01 {

    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();
    private static ThreadLocal<Transaction> transactionThreadLocal = new ThreadLocal<Transaction>();

    public static Session getSession(EntityManager em) {
        Session session = sessionThreadLocal.get();
        if (session == null) {
            session = em.getTransaction().getRootEntity().getSession();
            sessionThreadLocal.set(session);
        }
        return session;
    }

    public static void beginTransaction(EntityManager em) {
        Session session = sessionThreadLocal.get();
        Transaction transaction = transactionThreadLocal.get();
        if (session == null || transaction == null) {
            transaction = session.beginTransaction();
            transactionThreadLocal.set(transaction);
        }
    }

    public static void commitTransaction(EntityManager em) {
        Session session = sessionThreadLocal.get();
        Transaction transaction = transactionThreadLocal.get();
        if (session != null && transaction != null && transaction.isActive()) {
            transaction.commit();
            transaction = null;
            session = null;
            sessionThreadLocal.set(session);
            transactionThreadLocal.set(transaction);
        }
    }

    public static void rollbackTransaction(EntityManager em) {
        Session session = sessionThreadLocal.get();
        Transaction transaction = transactionThreadLocal.get();
        if (session != null && transaction != null) {
            transaction.rollback();
            transaction = null;
            session = null;
            sessionThreadLocal.set(session);
            transactionThreadLocal.set(transaction);
        }
    }
}