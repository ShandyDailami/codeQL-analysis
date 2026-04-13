import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_07345_JDBCQueryHandler_A07 {
    // Creating a method to authenticate the user
    public static boolean authenticateUser(String username, String password) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName(driver);

            // Establish Connection
            connection = DriverManager.getConnection(url, "username", "password");

            // Prepare statement
            statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");

            // Set parameter
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute query
            resultSet = statement.executeQuery();

            // Verify user
            if (resultSet.next()) {
                return true;
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return false;
    }

    // Creating a method to main function
    public static void main(String[] args) throws SQLException {
        // Authenticate user
        boolean isAuthenticated = authenticateUser("test", "test");

        // Print result
        System.out.println("Is authenticated? " + isAuthenticated);
    }
}