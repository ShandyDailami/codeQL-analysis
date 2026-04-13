import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31851_JDBCQueryHandler_A07 {

    // Step 1: Include necessary libraries
    // Step 2: Secure your database connection details
    private static final String DB_URL = "jdbc:mysql://your-db-url";
    private static final String USER = "user";
    private static final String PASS = "password";

    // Step 3: Establish a connection with your database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Step 4: Implement a query handler method
    public void performQuery(String query, ResultHandler resultHandler) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        resultHandler.handle(statement.executeQuery());
        connection.close();
    }

    // Step 5: Define a ResultHandler interface
    public interface ResultHandler {
        void handle(ResultSet resultSet) throws SQLException;
    }
}