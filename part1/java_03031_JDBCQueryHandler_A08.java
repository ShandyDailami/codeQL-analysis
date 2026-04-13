import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_03031_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Connection URL
        String url = "jdbc:mysql://localhost:3306/mydb";

        // Database credentials
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users");

            // Step 4: Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}