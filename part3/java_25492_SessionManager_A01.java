import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_25492_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_25492_SessionManager_A01() {
        initializeSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private void initializeSessionFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sessionFactory = new org.hibernate.cfg.Configuration()
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", URL)
                    .setProperty("hibernate.connection.username", USER)
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .addAnnotatedClass(Entity.class)
                    .openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = sessionFactory.openSession().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}