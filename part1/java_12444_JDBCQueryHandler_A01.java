import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12444_JDBCQueryHandler_A01 {

    public ResultSet executeQuery(String query) throws SQLException {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        // Create a connection to the database
        Connection connection = DriverManager.getConnection(url, username, password);

        // Create a statement from the connection
        Statement statement = connection.createStatement();

        // Execute the query
        ResultSet resultSet = statement.executeQuery(query);

        // Close the statement and connection
        statement.close();
        connection.close();

        // Return the result set
        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        // Create a connection to the database
        Connection connection = DriverManager.getConnection(url, username, password);

        // Create a statement from the connection
        Statement statement = connection.createStatement();

        // Execute the update
        statement.executeUpdate(query);

        // Close the statement and connection
        statement.close();
        connection.close();
    }
}