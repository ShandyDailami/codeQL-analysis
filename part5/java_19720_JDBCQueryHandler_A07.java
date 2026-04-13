import java.sql.*;

public class java_19720_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            authenticate();
        } catch (SQLException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    private static void authenticate() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);

        // Execute a SELECT query to check the user's credentials
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT 1 FROM users WHERE username = '" + USER + "' AND password = '" + PASS + "'");

        // If the query returned a result, the authentication was successful
        if (resultSet.next()) {
            System.out.println("Authentication successful");
        } else {
            throw new SQLException("Invalid username or password");
        }

        // Close the connection
        connection.close();
    }
}