import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_31442_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish database connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            // Step 3: Create a statement object
            try (Statement statement = connection.createStatement()) {

                // Step 4: Execute a SQL statement
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

                // Step 5: Process the result
                while (resultSet.next()) {
                    String employeeName = resultSet.getString("name");
                    int employeeAge = resultSet.getInt("age");

                    System.out.println("Employee Name: " + employeeName);
                    System.out.println("Employee Age: " + employeeAge);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}