import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_01424_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Setup the Database Connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 2: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Establish the Database Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 4: Create a new statement
            statement = connection.createStatement();

            // Step 5: Execute the query
            String query = "SELECT * FROM my_table";
            resultSet = statement.executeQuery(query);

            // Step 6: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Clean up
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}