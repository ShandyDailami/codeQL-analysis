import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35159_SessionManager_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionManager sessionManager;
    private static Connection connection;

    private java_35159_SessionManager_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();
        Connection connection = sessionManager.getConnection();

        // Insecure operation: directly using the connection for SQL operation
        // This is a security sensitive operation due to the lack of a transaction
        // and SQL injection vulnerability.
        try {
            connection.createStatement().execute("SELECT * FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sessionManager.closeConnection();
    }
}