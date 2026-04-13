import java.sql.*;

public class java_33152_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_33152_JDBCQueryHandler_A08(String dbUrl, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, userName, password);
    }

    public boolean isValidUser(String username) throws SQLException {
        // Create a statement
        Statement stmt = connection.createStatement();

        // Execute a query
        ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '" + username + "'");

        // Check if the query returned a result
        if (rs.next()) {
            // If so, the user is valid
            return true;
        } else {
            // If not, the user is not valid
            return false;
        }
    }
}