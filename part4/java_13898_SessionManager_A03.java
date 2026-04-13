import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_13898_SessionManager_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static SessionFactory sessionFactory;

    private java_13898_SessionManager_A03() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                sessionFactory = new Configuration()
                        .setDriverClass(com.mysql.cj.jdbc.Driver.class)
                        .setJdbcUrl(URL)
                        .setUsername(USER)
                        .setPassword(PASSWORD)
                        .configure()
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = getSessionFactory();
        Connection connection = getConnection();

        if (sessionFactory != null && connection != null) {
            System.out.println("Session Factory is connected to the database.");

            // Open a transaction
            connection.setAutoCommit(false);

            // Start a new transaction
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // Here is where you would perform security-sensitive operations

            // Commit the transaction
            session.getTransaction().commit();
            session.close();

            // Close the connection
            connection.close();

        } else {
            System.out.println("Could not connect to the database.");
        }
    }
}