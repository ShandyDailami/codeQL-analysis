import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_41004_JDBCQueryHandler_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load MySQL Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Connect to MySQL Server
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL Query
            String sql = "INSERT INTO test_table (id, name, age) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Execute SQL Query
            pstmt.setInt(1, 1001);
            pstmt.setString(2, "John");
            pstmt.setInt(3, 25);
            pstmt.executeUpdate();

            // Step 5: Close connections
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}