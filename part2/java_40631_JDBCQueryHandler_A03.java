import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_40631_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // Step 5: Process the result
            while (resultSet.next()) {
                String employeeName = resultSet.getString("employeeName");
                int employeeId = resultSet.getInt("employeeId");
                double employeeSalary = resultSet.getDouble("employeeSalary");

                System.out.println("Employee Name: " + employeeName);
                System.out.println("Employee ID: " + employeeId);
                System.out.println("Employee Salary: " + employeeSalary);
            }

            // Step 6: Clean up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}