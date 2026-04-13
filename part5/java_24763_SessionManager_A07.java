import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24763_SessionManager_A07 {
    private static AuthFailureSessionManager instance = null;

    private java_24763_SessionManager_A07() {
    }

    public static AuthFailureSessionManager getInstance() {
        if (instance == null) {
            instance = new AuthFailureSessionManager();
        }
        return instance;
    }

    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost/test", "username", "password");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
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
}