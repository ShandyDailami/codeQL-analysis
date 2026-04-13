import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12383_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Establish a connection
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "password";
            conn = DriverManager.getConnection(url, username, password);

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute a query
            rs = stmt.executeQuery("SELECT * FROM Employees");

            // 4. Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Close the ResultSet and Statement
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}