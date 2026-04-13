import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_35010_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // Update with your database URL
        String username = "root"; // Update with your username
        String password = "password"; // Update with your password

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM employees"; // Update with your SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String employeeName = resultSet.getString("employeeName");
                int employeeAge = resultSet.getInt("employeeAge");
                System.out.println("Employee Name: " + employeeName);
                System.out.println("Employee Age: " + employeeAge);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}