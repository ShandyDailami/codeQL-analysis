import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_40779_JDBCQueryHandler_A03 {
    // Step 1: Load the database driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find MySQL driver", e);
        }
    }

    // Step 2: Establish a connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb?useSSL=false",
                "username",
                "password");
    }

    // Step 3: Execute a query
    public void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result set
            while (resultSet.next()) {
                // Process each row of the result set
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Step 5: Create a new instance of the JDBCQueryHandler
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();

        // Step 6: Execute a query
        jdbcQueryHandler.executeQuery("SELECT * FROM users");
    }
}