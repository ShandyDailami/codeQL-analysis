import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38778_SessionManager_A03 {

    private String url;
    private String username;
    private String password;
    private Connection connection;

    public java_38778_SessionManager_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.out.println("Error getting connection: " + e.getMessage());
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}