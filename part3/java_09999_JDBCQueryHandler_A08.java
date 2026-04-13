import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09999_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement stmt = connection.createStatement()) {

            String sql = "UPDATE employees SET salary = salary + 100 WHERE department_id = 1";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error in updating employees' salary: " + e);
        }
    }
}