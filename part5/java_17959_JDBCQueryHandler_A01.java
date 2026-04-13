import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17959_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "employee";
        String password = "employee";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM EMPLOYEES WHERE SALARY > 5000";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String employeeName = resultSet.getString("EMPLOYEE_NAME");
                int salary = resultSet.getInt("SALARY");

                System.out.println("Employee Name: " + employeeName);
                System.out.println("Salary: " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}