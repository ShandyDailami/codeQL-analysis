public class java_10514_SessionManager_A07 {
    private SessionFactory sessionFactory;

    public java_10514_SessionManager_A07(String connectionUrl, String username, String password) {
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactoryBuilder sessionFactoryBuilder = new SessionFactoryBuilder(configuration);
        sessionFactory = sessionFactoryBuilder.build();

        // Setting security configuration
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("FROM com.example.security.User WHERE username = :username")
                .setParameter("username", username)
                .setTransaction(transaction)
                .list().stream().findFirst();

        if (session.getTransaction().getStatus().equals(Status.ACTIVE)) {
            session.getTransaction().commit();
        }

        if (session.getSession().isOpen()) {
            session.getSession().close();
        }
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}