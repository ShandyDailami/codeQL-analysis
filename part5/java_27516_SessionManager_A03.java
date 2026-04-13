import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27516_SessionManager_A03 {

    // The URL, username, and password for the database.
    // They are made static because they are not parameters to the session manager methods.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "myuser";
    private static final String PASSWORD = "mypassword";

    // A method that creates a connection to the database.
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    // A method that closes the connection.
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Handle the exception here, if needed.
            }
        }
    }

    // A method that demonstrates the use of SQL injection.
    public void demonstrateInjection(Connection connection, String userInput) {
        // This code does not actually execute, but demonstrates the use of userInput as a part of the SQL statement.
        try {
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // This line does not actually do anything, but demonstrates how userInput can be used as part of a query.
        } catch (SQLException e) {
            // Handle the exception here, if needed.
        }
    }
}