import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_01352_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        // Setup DriverManager
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // Execute SQL Query
            String sql = "SELECT * FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Handle ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}