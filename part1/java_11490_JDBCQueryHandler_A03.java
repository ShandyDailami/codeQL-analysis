import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_11490_JDBCQueryHandler_A03 {
    // Step 1: Declare database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Step 2: Declare a method to connect to the database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Step 3: Declare a method to close the database connection
    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    // Step 4: Declare a method to execute a query
    public ResultSet executeQuery(Connection connection, String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    // Step 5: Declare a method to perform an operation that requires security
    public void secureOperation(Connection connection) throws SQLException {
        // Imagine we're inserting a user's password in cleartext
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "example_username");
        statement.setString(2, "example_password");
        statement.execute();

        // Imagine we're reading a user's password in cleartext
        sql = "SELECT password FROM users WHERE username = ?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, "example_username");
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String password = resultSet.getString(1);
            System.out.println(password); // This could be a security issue
        }
    }
}