import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22890_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // 1. Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // 3. Prepare the SQL query
            String query = "SELECT * FROM employees WHERE department_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // 4. Set the parameter value
            preparedStatement.setInt(1, 10);

            // 5. Execute the query and get the result
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Department ID: " + resultSet.getInt("department_id"));
                System.out.println("Employee Name: " + resultSet.getString("employee_name"));
                System.out.println("Email: " + resultSet.getString("email"));
            }

            // 6. Close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}