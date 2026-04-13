import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_00922_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // 1. Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open a connection to the MySQL server
            Connection connection = DriverManager.getConnection(url, username, password);

            // 3. Execute a query
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(sql);

            // 4. Process the result set
            while (resultSet.next()) {
                String employeeName = resultSet.getString("employee_name");
                int employeeId = resultSet.getInt("employee_id");
                System.out.println("Name: " + employeeName + ", ID: " + employeeId);
            }

            // 5. Close the connection to the database
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}