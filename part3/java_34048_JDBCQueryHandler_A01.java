import java.sql.*;

public class java_34048_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM employees WHERE salary > ? AND department_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set parameters
            preparedStatement.setInt(1, 5000);
            preparedStatement.setInt(2, 10);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getInt("id"));
                System.out.println("Employee Name: " + resultSet.getString("name"));
                System.out.println("Employee Salary: " + resultSet.getInt("salary"));
                System.out.println("Employee Department ID: " + resultSet.getInt("department_id"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}