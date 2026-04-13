import java.sql.*;

public class java_10596_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String employeeName = resultSet.getString("employeeName");
                int employeeId = resultSet.getInt("employeeId");
                double employeeSalary = resultSet.getDouble("employeeSalary");

                System.out.println("Employee Name: " + employeeName);
                System.out.println("Employee ID: " + employeeId);
                System.out.println("Employee Salary: " + employeeSalary);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}