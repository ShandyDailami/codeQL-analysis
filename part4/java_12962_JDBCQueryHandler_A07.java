import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_12962_JDBCQueryHandler_A07 {
    private final String url;
    private final String username;
    private final String password;

    public java_12962_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(url, username, password);

            // Prepare the SQL query
            statement = connection.prepareStatement(query);

            // Execute the query and get a result set
            resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                // This is a placeholder for your security-sensitive operation
                // You should replace this with your actual operation
                System.out.println("Processing result: " + resultSet.getString("column_name"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            if (statement != null) {
                try {
                    statement.close();
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

        return resultSet;
    }
}