import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_03642_SessionManager_A08 {
    private Connection connection;

    public java_03642_SessionManager_A08(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect to database. Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: Unable to close database connection. Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}