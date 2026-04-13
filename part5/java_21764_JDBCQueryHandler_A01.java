import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_21764_JDBCQueryHandler_A01 {
    // Hard-coded username and password for simplicity, in a real-world application
    // these should be fetched from a secure source, such as a configuration file or environment variables
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // SQL query
    private static final String QUERY = "SELECT * FROM users WHERE username = ?";

    public ResultSet executeQuery(String username) throws SQLException {
        // Step 1: Load the driver
        Class.forName(DRIVER);

        // Step 2: Establish a connection
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // Step 3: Prepare and execute the query
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();

        // Step 4: Close the connection
        connection.close();

        return resultSet;
    }
}