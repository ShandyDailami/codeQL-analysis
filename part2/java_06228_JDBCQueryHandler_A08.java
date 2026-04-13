import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06228_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employees");

            // Step 2: Process the result set
            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int salary = rs.getInt("salary");
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close connections
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}