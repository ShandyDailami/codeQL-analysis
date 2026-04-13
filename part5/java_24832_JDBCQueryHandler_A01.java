import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_24832_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Setup JDBC connection
        String url = "your_database_url"; // Replace with your database URL
        String username = "your_username"; // Replace with your username
        String password = "your_password"; // Replace with your password

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Prepare the SQL query
            String query = "SELECT * FROM your_table"; // Replace with your SQL query
            preparedStatement = connection.prepareStatement(query);

            // Execute the query and process the result
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Record: " + resultSet.getString("your_column")); // Replace "your_column" with your actual column name
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
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