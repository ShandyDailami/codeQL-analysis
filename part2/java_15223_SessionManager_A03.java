import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_15223_SessionManager_A03 {
    private static SessionManager instance;
    private static SessionFactory sessionFactory;

    private java_15223_SessionManager_A03() {
        // load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // create connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password");

        // create session factory
        sessionFactory = new org.hibernate.cfg.Configuration()
                .configure()
                .buildSessionFactory(connection);
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}