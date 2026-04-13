import java.sql.*;

public class java_39598_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Open connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create statement
            statement = connection.createStatement();

            // 3. Execute SQL query
            String query = "SELECT * FROM employees WHERE salary > ? AND department_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 5000);
            preparedStatement.setInt(2, 10);
            resultSet = preparedStatement.executeQuery();

            // 4. Process result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                int departmentId = resultSet.getInt("department_id");
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
                System.out.println("Department ID: " + departmentId);
            }

            // 5. Close connection
            resultSet.close();
            preparedStatement.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}