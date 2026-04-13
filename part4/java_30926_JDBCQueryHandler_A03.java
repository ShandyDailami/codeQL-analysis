import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_30926_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Connect to MySQL Server
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare SQL Query
            String sql = "SELECT * FROM mytable WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 123); // example value

            // Step 4: Execute Query
            rs = pstmt.executeQuery();

            // Step 5: Process ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close DB Resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* ignored */ }
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { /* ignored */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* ignored */ }
            }
        }
    }
}