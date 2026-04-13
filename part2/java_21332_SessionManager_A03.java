import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21332_SessionManager_A03 {
    private String url;
    private String username;
    private String password;

    public java_21332_SessionManager_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("jdbc:mysql://localhost:3306/test", "root", "root");
        Connection connection = sessionManager.getConnection();
        if (connection != null) {
            System.out.println("Connection established successfully!");
            sessionManager.closeConnection(connection);
        } else {
            System.out.println("Failed to establish connection!");
        }
    }
}