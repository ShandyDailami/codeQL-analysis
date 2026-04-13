import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_07493_SessionManager_A01 {
    private static SessionManager instance;
    private static Connection connection;

    private java_07493_SessionManager_A01() {
        try {
            // Use a standard driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase",
                    "username",
                    "password");
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions appropriately
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
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }
    }
}