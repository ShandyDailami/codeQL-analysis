import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31507_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 3. Prepare a statement
            pstmt = conn.prepareStatement("SELECT * FROM users WHERE name = ?");

            // 4. Execute the statement
            pstmt.setString(1, "John Doe");
            rs = pstmt.executeQuery();

            // 5. Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Name: " + name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the resources
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* ignore */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* ignore */ }
            if (conn != null) try { conn.close(); } catch (SQLException e) { /* ignore */ }
        }
    }
}