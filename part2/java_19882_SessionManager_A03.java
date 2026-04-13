public class java_19882_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_19882_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void openSession(String userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Here we're using an example-sensitive operation.
        // This operation is not suitable for all situations, as it's not secure against injection.
        // This is just an example to illustrate the concept.
        User user = session.get(User.class, userId);

        session.getTransaction().commit();
        session.close();
    }
}