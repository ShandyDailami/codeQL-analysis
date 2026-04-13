import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_10334_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionFactory sessionFactory;

    public static void init() {
        if (sessionFactory == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                sessionFactory = new org.hibernate.cfg.Configuration()
                        .configure()
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        return sessionFactory.openSession().getConnection();
    }

    public static void close() {
        sessionFactory.close();
    }
}