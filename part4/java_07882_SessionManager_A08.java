public class java_07882_SessionManager_A08 {
    // Create a session factory and a session
    private static org.hibernate.SessionFactory sessionFactory;  
    private static org.hibernate.Session session;

    // Create a connection to the database
    private static String url = "jdbc:mysql://localhost:3306/testdb";
    private static String username = "root";
    private static String password = "password";

    // Make sure we only create a session factory once
    private static SessionManager instance = null;

    // Create a Singleton instance
    public static SessionManager getInstance() {
        if (instance == null)
            instance = new SessionManager();
        return instance;
    }

    // Create a session factory
    private java_07882_SessionManager_A08() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sessionFactory = org.hibernate.cfg.Configuration.
                    configure().
                    dataSource(url, username, password).
                    buildSessionFactory();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Create a session
    public org.hibernate.Session getSession() {
        session = sessionFactory.openSession();
        return session;
    }

    // Close the session
    public void closeSession() {
        session.close();
    }
}