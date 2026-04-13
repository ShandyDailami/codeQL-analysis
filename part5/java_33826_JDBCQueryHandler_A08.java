import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_33826_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Get connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare SQL statement
            statement = connection.createStatement();

            // Step 4: Execute SQL query
            String sql = "SELECT * FROM Employees";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Process ResultSet
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close connections
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