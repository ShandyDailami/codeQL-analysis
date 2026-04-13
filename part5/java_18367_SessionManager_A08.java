import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18367_SessionManager_A08 {

    // Loading the database driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // The method that creates a database connection
    public Connection createConnection(String url, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // The method that closes the database connection
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
        // Creating a connection
        Connection connection = null;
        try {
            connection = new SessionManager().createConnection("jdbc:mysql://localhost:3306/test", "root", "password");

            // Performing a security-sensitive operation that might fail
            connection.createStatement().execute("DROP TABLE users");
            connection.createStatement().execute("SELECT * FROM users");

            // Closing the connection
            new SessionManager().closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}