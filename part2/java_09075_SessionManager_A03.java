import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09075_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_09075_SessionManager_A03() {
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connect to the database
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
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
        // ... use the connection
        sessionManager.closeConnection();
    }
}