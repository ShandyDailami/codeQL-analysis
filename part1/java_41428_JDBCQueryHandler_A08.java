import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_41428_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute a query
            String sql = "SELECT * FROM my_table";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Process the result
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Disconnect
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}