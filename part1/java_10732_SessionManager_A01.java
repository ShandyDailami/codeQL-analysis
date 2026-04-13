public class java_10732_SessionManager_A01 {

    // Step 1: Define a SessionFactory
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        // Step 2: Create a new SessionFactory
        sessionFactory = new Configuration().configure().buildSessionFactory();

        // Step 3: Start a new thread to avoid access violation errors
        new Thread(() -> {
            // Step 4: Access the SessionFactory
            Session session = sessionFactory.openSession();

            // Step 5: Perform operations on the session
            session.beginTransaction();

            // Assume we're trying to access a broken account
            Account brokenAccount = session.get(Account.class, 123);

            // This will fail due to lack of permissions
            brokenAccount.setPassword("NEW PASSWORD");
            session.update(brokenAccount);

            session.getTransaction().commit();
            session.close();
        }).start();
    }
}