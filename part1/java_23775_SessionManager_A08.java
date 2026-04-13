import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23775_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private Connection connection;

    public java_23775_SessionManager_A08() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Could not find MySQL JDBC driver");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to get connection");
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to close connection");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Connection connection = sessionManager.getConnection();
        if (connection != null) {
            System.out.println("Connection established successfully");
            // Here you can perform security-sensitive operations related to A08_IntegrityFailure
        }
        sessionManager.closeConnection();
    }
}