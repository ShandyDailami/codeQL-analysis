public class java_30737_SessionManager_A07 {
    private static SessionFactory sessionFactory;

    // Initialize sessionFactory
    public static void initialize(String driver, String url, String username, String password) {
        try {
            sessionFactory = new Configuration().addAnnotatedClass(User.class).addAnnotatedClass(Order.class).configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to get a session
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Method to begin a transaction
    public static Transaction beginTransaction() {
        return getSession().beginTransaction();
    }

    // Method to commit a transaction
    public static void commitTransaction(Transaction transaction) {
        transaction.commit();
    }

    // Method to rollback a transaction
    public static void rollbackTransaction(Transaction transaction) {
        transaction.rollback();
    }

    // Method to close the session
    public static void closeSession(Session session) {
        session.close();
    }

    // Security-sensitive operation: login
    public static User login(String username, String password) {
        User user = null;
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE username = :username");
            query.setParameter("username", username);

            user = (User) query.uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                transaction.commit();
            } else {
                transaction.rollback();
                throw new AuthFailureException("Authentication failed.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return user;
    }
}