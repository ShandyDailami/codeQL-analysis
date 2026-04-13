import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_29864_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Load JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
            return;
        }

        // Step 2: Create connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "username", "password")) {

            // Step 3: Prepare SQL statement
            String sql = "SELECT * FROM employees WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 4: Bind parameters
            statement.setString(1, "John");

            // Step 5: Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Step 6: Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

        } catch (SQLException e) {
            System.out.println("Error executing SQL query.");
            e.printStackTrace();
        }
    }
}