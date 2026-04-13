import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_34616_JDBCQueryHandler_A07 {

    // Username and password for database authentication
    private final String username = "username";
    private final String password = "password";

    // Database connection URL
    private final String url = "jdbc:mysql://localhost:3306/database_name";

    // Create a method to connect to the database
    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Create a method to execute a query
    public ResultSet executeQuery(String query) {
        Connection connection = connect();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }

    // Example usage
    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE role = 'admin'");
        try {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}