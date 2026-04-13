import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05638_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Establish connection
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employees WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");
            while (rs.next()) {
                System.out.println("Access granted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}