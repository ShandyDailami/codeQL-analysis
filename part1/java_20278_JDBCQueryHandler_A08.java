import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_20278_JDBCQueryHandler_A08 {
    private static final String JDBC_URL = "<url>";
    private static final String USERNAME = "<username>";
    private static final String PASSWORD = "<password>";
    private static final String DB_NAME = "<database>";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create SQL query
            String query = "SELECT * FROM Users WHERE username = ?";

            // Prepare statement
            preparedStatement = connection.prepareStatement(query);

            // Set parameter value
            preparedStatement.setString(1, "testUser");

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Process result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}