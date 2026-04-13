import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_19049_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        // Set up database connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Set up SQL statement
            String query = "SELECT * FROM employees";

            Statement statement = connection.createStatement();

            // Execute SQL statement
            ResultSet resultSet = statement.executeQuery(query);

            // Process result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

            // Close database connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}