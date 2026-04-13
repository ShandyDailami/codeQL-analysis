import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_24485_JDBCQueryHandler_A03 {

    // JDBC driver name and database URL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL driver
            Class.forName(driver);

            // Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // Prepare statement for execution
            String sql = "SELECT * FROM my_table WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 123); // Set the value of id

            // Execute the query
            rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* Nothing to do */ }
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { /* Nothing to do */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* Nothing to do */ }
            }
        }
    }
}