// a. 
public class java_34389_SessionManager_A01 {
    // c.
    private static org.hibernate.SessionFactory sessionFactory;

    // c.
    public static org.hibernate.SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // a.
                Class.forName("com.mysql.jdbc.Driver");
                // a.
                sessionFactory = org.hibernate.cfg.Configuration.buildSessionFactory(
                        new org.hibernate.cfg.Configuration()
                                .setProperty("hibernate.dialect", "com.mysql.jdbc.Dialect")
                                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test")
                                .setProperty("hibernate.connection.username", "root")
                                .setProperty("hibernate.connection.password", "root")
                                .setProperty("hibernate.hbm2ddl.auto", "update")
                                .addAnnotatedClass(com.example.model.Employee.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    // b.
    public void openSessionAndExecute(final SessionExecutionAction action) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            action.execute(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public interface SessionExecutionAction {
        void execute(org.hibernate.Session session);
    }
}