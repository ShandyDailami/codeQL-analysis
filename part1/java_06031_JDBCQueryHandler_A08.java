import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06031_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();) {
            
            String sql = "SELECT * FROM employees WHERE salary > ? AND department = ?";
            statement.executeUpdate(sql, 5000, "Marketing");
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                String department = resultSet.getString("department");
                
                System.out.println("id: " + id + ", name: " + name + ", salary: " + salary + ", department: " + department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}