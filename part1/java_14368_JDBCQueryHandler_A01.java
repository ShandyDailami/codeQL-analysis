import java.sql.*;

public class java_14368_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create Statement
            statement = connection.createStatement();

            // Step 4: Execute Query
            resultSet = statement.executeQuery("SELECT * FROM employees");

            // Step 5: Process Result
            while (resultSet.next()) {
                String employeeId = resultSet.getString("employee_id");
                String employeeName = resultSet.getString("employee_name");
                int employeeAge = resultSet.getInt("employee_age");

                System.out.println("Employee ID: " + employeeId);
                System.out.println("Employee Name: " + employeeName);
                System.out.println("Employee Age: " + employeeAge);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Cleanup
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