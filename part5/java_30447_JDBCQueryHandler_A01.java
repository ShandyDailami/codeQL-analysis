import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_30447_JDBCQueryHandler_A01 {

    // Insecure way of getting the database credentials
    private String dbUrl = "jdbc:mysql://localhost:3306/test";
    private String user = "root";
    private String password = "password";

    // Sensitive operation related to Broken Access Control
    public User getUserById(int id) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Setup Connection
            connection = DriverManager.getConnection(dbUrl, user, password);

            // Step 2: Prepare the SQL Query
            String sql = "SELECT * FROM users WHERE id = " + id;
            statement = connection.createStatement();

            // Step 3: Execute SQL Query
            resultSet = statement.executeQuery(sql);

            // Step 4: Handle ResultSet
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");

                return new User(id, username, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close Database Resources
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

        return null;
    }
}