import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12550_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

            while (rs.next()) {
                System.out.println(rs.getString("EmployeeID") + " - " + rs.getString("FirstName") + " - " + rs.getString("LastName"));
            }

        } catch (SQLException e) {
            System.out.println("Error in connection: " + e.getMessage());
        }
    }
}