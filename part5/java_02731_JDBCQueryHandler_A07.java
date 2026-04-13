import java.sql.*;

public class java_02731_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establish connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare statement
            String query = "SELECT * FROM Employees WHERE Salary > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set parameter and execute statement
            preparedStatement.setFloat(1, 50000);
            resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result
            while (resultSet.next()) {
                String employeeName = resultSet.getString("EmployeeName");
                float salary = resultSet.getFloat("Salary");
                System.out.println("Employee Name: " + employeeName + ", Salary: " + salary);
            }

            // Step 5: Clean up
            resultSet.close();
            preparedStatement.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}