import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27342_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_27342_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

class AuthFailureExample {
    public static void main(String[] args) {
        // Setup
        JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbcUrl", "username", "password");
        Connection connection = null;

        try {
            // Start query
            connection = queryHandler.getConnection();
            // your code here

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // Close connection
            if (connection != null) {
                queryHandler.closeConnection(connection);
            }
        }
    }
}