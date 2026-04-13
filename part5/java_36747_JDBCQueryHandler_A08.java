import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_36747_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:your_connection_url";
        String username = "username";
        String password = "password";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare the SQL query
            String query = "SELECT * FROM your_table";
            preparedStatement = connection.prepareStatement("SELECT * FROM your_table");

            // Step 4: Execute the query
            resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result set
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                // ... and so on for all columns
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
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