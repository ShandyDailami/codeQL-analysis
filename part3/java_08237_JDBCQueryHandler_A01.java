import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_08237_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");

            // Step 3: Execute SQL query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            // Step 6: Cleanup
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException se2) {}
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException se2) { se2.printStackTrace(); }
            }
        }
    }
}