import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_32886_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionManager sessionManager;
    private static SessionFactory sessionFactory;

    private java_32886_SessionManager_A03() {
        // Private constructor to prevent instantiation from outside
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();

            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        }

        return sessionManager;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public Session getSession(Connection connection) {
        Session session = null;
        try {
            session = sessionFactory.openSession(connection);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return session;
    }

    public void close(Session session) {
        if (session != null) {
            session.close();
        }
    }
}