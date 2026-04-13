import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01367_SessionManager_A03 {

    // The URL of the database (you will need to replace this with your actual database URL)
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";

    // The username and password for the database (you will need to replace these with your actual database credentials)
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // The SessionFactory is a factory for creating session objects
    private static SessionFactory sessionFactory;

    // The static initializer for the SessionFactory
    static {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Set up the database connection parameters
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        // Set up a connection pool settings
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxActive(20);

        // Set up the session factory
        sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory(dataSource);
    }

    // Method to open a session
    public Connection openSession() {
        try {
            return sessionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Connection connection = sessionManager.openSession();

        // Now you can use the connection to perform operations on your database
        // For example, you can save an object to the database

        // After you're done with the session and connection, you should close them
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}