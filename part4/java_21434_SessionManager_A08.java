import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21434_SessionManager_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myUser";
    private static final String PASSWORD = "myPassword";

    private Connection connection;

    public java_21434_SessionManager_A08() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Perform security-sensitive operations here
        // For example, you can use sessionManager.getConnection() to get a connection to the database

        sessionManager.closeConnection();
    }
}