import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_07553_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        // Step 1: Establish a connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Prepare and execute a SQL query
        String query = "SELECT * FROM Users WHERE username = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "validUsername");
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 3: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                // Process the username here...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
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