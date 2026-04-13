import java.sql.*;

public class java_26347_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionManager sessionManager;
    private Connection connection;

    private java_26347_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
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
}

// Example of using the SessionManager
public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();
        Connection connection = sessionManager.getConnection();

        // Your security-sensitive operations here

        sessionManager.closeConnection();
    }
}