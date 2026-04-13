import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25159_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute a query
            rs = stmt.executeQuery("SELECT * FROM employees");

            // Step 5: Process the result set
            while (rs.next()) {
                String employeeId = rs.getString("employeeId");
                String employeeName = rs.getString("employeeName");
                System.out.println(employeeId + ", " + employeeName);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
            if (rs != null) try { rs.close(); } catch(SQLException ignore) {}
            if (stmt != null) try { stmt.close(); } catch(SQLException ignore) {}
            if (conn != null) try { conn.close(); } catch(SQLException ignore) {}
        }
    }
}