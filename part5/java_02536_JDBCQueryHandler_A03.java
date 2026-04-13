import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_02536_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(url, username, password);

            // Define SQL query
            String sql = "SELECT * FROM users WHERE username = ?";

            // Create a prepared statement
            preparedStatement = connection.prepareStatement(sql);

            // Set parameter value
            preparedStatement.setString(1, "testUser");

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                System.out.println("Username: " + username);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}